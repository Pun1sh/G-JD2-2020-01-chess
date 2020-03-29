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
import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IMoveDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.filter.MoveFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Move;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Move_;

@Repository
public class MoveDaoImpl extends AbstractDaoImpl<IMove, Integer> implements IMoveDao {

	@Override
	public IMove createEntity() {
		return new Move();
	}

	protected MoveDaoImpl() {
		super(Move.class);
	}

	@Override
	public List<IMove> find(MoveFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IMove> cq = cb.createQuery(IMove.class); // define
																		// type
																		// of
		// result
		final Root<Move> from = cq.from(Move.class);// select from brand
		cq.select(from); // select what? select *
		from.fetch(Move_.game, JoinType.LEFT);
		from.fetch(Move_.player, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Move, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}
		final TypedQuery<IMove> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(MoveFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Move> from = cq.from(Move.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Move, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Move_.id;
		case "moveNotationTo":
			return Move_.moveNotationTo;
		case "moveNotationFrom":
			return Move_.moveNotationFrom;
		case "moveTime":
			return Move_.moveTime;
		case "piece":
			return Move_.piece;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public IMove getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IMove> cq = cb.createQuery(IMove.class); // define returning result
		final Root<Move> from = cq.from(Move.class); // define table for select

		cq.select(from); // define what need to be selected

		from.fetch(Move_.game, JoinType.LEFT);
		from.fetch(Move_.player, JoinType.LEFT);

		// .. where id=...
		cq.where(cb.equal(from.get(Move_.id), id)); // where id=?

		final TypedQuery<IMove> q = em.createQuery(cq);

		return q.getSingleResult();
	}
}
