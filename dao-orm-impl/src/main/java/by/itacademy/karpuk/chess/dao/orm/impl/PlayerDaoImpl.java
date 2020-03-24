package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IPlayerDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Player;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Player_;

@Repository
public class PlayerDaoImpl extends AbstractDaoImpl<IPlayer, Integer> implements IPlayerDao {

	@Override
	public IPlayer createEntity() {
		return new Player();
	}

	protected PlayerDaoImpl() {
		super(Player.class);
	}

	@Override
	public List<IPlayer> find(PlayerFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IPlayer> cq = cb.createQuery(IPlayer.class); // define
																			// type
																			// of
		// result
		final Root<Player> from = cq.from(Player.class);// select from brand
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Player, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}

		final TypedQuery<IPlayer> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(PlayerFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Player> from = cq.from(Player.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Player, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Player_.id;
		case "password":
			return Player_.password;
		case "gamesPlayed":
			return Player_.gamesPlayed;
		case "surname":
			return Player_.surname;
		case "name":
			return Player_.name;
		case "nickname":
			return Player_.nickname;
		case "eloPoints":
			return Player_.eloPoints;
		case "rank":
			return Player_.rank;
		case "email":
			return Player_.email;
		case "registratedDate":
			return Player_.registratedDate;
		case "birthDate":
			return Player_.birthDate;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
