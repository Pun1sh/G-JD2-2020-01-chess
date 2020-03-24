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

import by.itacademy.karpuk.chess.dao.api.IBoardDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.filter.BoardFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Board;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Board_;

@Repository
public class BoardDaoImpl extends AbstractDaoImpl<IBoard, Integer> implements IBoardDao {

	@Override
	public IBoard createEntity() {
		return new Board();
	}

	protected BoardDaoImpl() {
		super(Board.class);
	}

	@Override
	public List<IBoard> find(BoardFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IBoard> cq = cb.createQuery(IBoard.class); // define
																		// type
																		// of
		// result
		final Root<Board> from = cq.from(Board.class);// select from brand
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Board, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}
		final TypedQuery<IBoard> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(BoardFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Board> from = cq.from(Board.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Board, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Board_.id;
		case "positionNumber":
			return Board_.positionNumber;
		case "positionLetter":
			return Board_.positionLetter;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
