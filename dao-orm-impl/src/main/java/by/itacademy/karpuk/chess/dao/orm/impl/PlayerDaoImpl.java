package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.jpa.criteria.OrderImpl;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
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
	public IPlayer getFullInfo(final Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IPlayer> cq = cb.createQuery(IPlayer.class); // define returning result
		final Root<Player> from = cq.from(Player.class); // define table for select

		cq.select(from); // define what need to be selected

		from.fetch(Player_.country, JoinType.LEFT);
		from.fetch(Player_.club, JoinType.LEFT);

		// .. where id=...
		cq.where(cb.equal(from.get(Player_.id), id)); // where id=?

		final TypedQuery<IPlayer> q = em.createQuery(cq);

		return q.getSingleResult();
	}

	@Override
	public IPlayer getPlayerByNickname(final String nickname) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IPlayer> cq = cb.createQuery(IPlayer.class); // define returning result
		final Root<Player> from = cq.from(Player.class); // define table for select
		cq.select(from); // select what? select *
		cq.where(cb.equal(from.get(Player_.nickname), nickname)); // where nickname=?
		final TypedQuery<IPlayer> q = em.createQuery(cq);
		q.setMaxResults(1);
		List<IPlayer> resultList = q.getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);

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

		from.fetch(Player_.club, JoinType.LEFT);

		from.fetch(Player_.country, JoinType.LEFT);

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
	public List<IPlayer> findWithoutLoggedPlayer(PlayerFilter filter, Integer loggedUserId) {

		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IPlayer> cq = cb.createQuery(IPlayer.class); // define type of result

		final Root<Player> from = cq.from(Player.class);// select from player
		cq.select(from); // select what? select *

		from.fetch(Player_.club, JoinType.LEFT);

		from.fetch(Player_.country, JoinType.LEFT);

		cq.where(cb.notEqual(from.get(Player_.id), loggedUserId)); // where id=?

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
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define type of result

		final Root<Player> from = cq.from(Player.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	@Override
	public List<IPlayer> search(String text) {

		EntityManager em = getEntityManager();
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query
		// parser
		// or the Lucene programmatic API. The Hibernate Search DSL is
		// recommended though
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Player.class).get();
		org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("nickname").matching(text).createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Player.class);

		return jpaQuery.getResultList();

	}

	private SingularAttribute<? super Player, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Player_.id;
		case "password":
			return Player_.password;
		case "gamesPlayed":
			return Player_.gamesPlayed;
		case "nickname":
			return Player_.nickname;
		case "eloPoints":
			return Player_.eloPoints;
		case "rank":
			return Player_.rank;
		case "email":
			return Player_.email;
		case "registrated":
			return Player_.registrated;
		case "birthDate":
			return Player_.birthDate;
		case "salt":
			return Player_.salt;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
