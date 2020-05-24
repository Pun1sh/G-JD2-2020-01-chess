package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IGameDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Game;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Game_;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Player_;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Tournament_;

@Repository
public class GameDaoImpl extends AbstractDaoImpl<IGame, Integer> implements IGameDao {

	@Override
	public IGame createEntity() {
		return new Game();
	}

	protected GameDaoImpl() {
		super(Game.class);
	}

	@Override
	public List<IGame> find(GameFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IGame> cq = cb.createQuery(IGame.class); // define
																		// type
																		// of
		// result
		final Root<Game> from = cq.from(Game.class);// select from brand
		cq.select(from); // select what? select *
		from.fetch(Game_.whitePlayer, JoinType.LEFT);
		from.fetch(Game_.blackPlayer, JoinType.LEFT);
		from.fetch(Game_.winner, JoinType.LEFT);
		from.fetch(Game_.loser, JoinType.LEFT);
		from.fetch(Game_.tournament, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final Path<?> expression = getSortPath(from, filter.getSortColumn());
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IGame> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(GameFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Game> from = cq.from(Game.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private Path<?> getSortPath(final Root<Game> from, final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return from.get(Game_.id);
		case "whitePlayerName":
			return from.get(Game_.whitePlayer).get(Player_.nickname);
		case "blackPlayerName":
			return from.get(Game_.blackPlayer).get(Player_.nickname);
		case "winnerName":
			return from.get(Game_.winner).get(Player_.nickname);
		case "loserName":
			return from.get(Game_.loser).get(Player_.nickname);
		case "tournamentName":
			return from.get(Game_.tournament).get(Tournament_.name);
		case "mode":
			return from.get(Game_.mode);
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public IGame getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IGame> cq = cb.createQuery(IGame.class); // define returning result
		final Root<Game> from = cq.from(Game.class); // define table for select

		cq.select(from); // define what need to be selected

		from.fetch(Game_.whitePlayer, JoinType.LEFT);
		from.fetch(Game_.blackPlayer, JoinType.LEFT);
		from.fetch(Game_.winner, JoinType.LEFT);
		from.fetch(Game_.loser, JoinType.LEFT);
		from.fetch(Game_.tournament, JoinType.LEFT);

		// .. where id=...
		cq.where(cb.equal(from.get(Game_.id), id)); // where id=?

		final TypedQuery<IGame> q = em.createQuery(cq);

		return q.getSingleResult();
	}

	@Override
	public IGame checkForGame(Integer playerId) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IGame> cq = cb.createQuery(IGame.class); // define returning result
		final Root<Game> from = cq.from(Game.class); // define table for select

		cq.select(from); // define what need to be selected

		from.fetch(Game_.whitePlayer, JoinType.LEFT);
		from.fetch(Game_.blackPlayer, JoinType.LEFT);

		cq.orderBy(new OrderImpl(from.get(Game_.started), false));
		Predicate isNotEnded = cb.isNull(from.get(Game_.ended));
		cq.where(cb.and(isNotEnded, cb.or(cb.equal(from.get(Game_.blackPlayer), playerId),
				cb.equal(from.get(Game_.whitePlayer), playerId))));

		final TypedQuery<IGame> q = em.createQuery(cq);
		q.setMaxResults(1);
		List<IGame> resultList = q.getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);

	}

}
