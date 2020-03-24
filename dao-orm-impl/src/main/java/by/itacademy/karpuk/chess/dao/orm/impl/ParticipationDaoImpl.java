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

import by.itacademy.karpuk.chess.dao.api.IParticipationDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Participation;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Participation_;

@Repository
public class ParticipationDaoImpl extends AbstractDaoImpl<IParticipation, Integer> implements IParticipationDao {

	@Override
	public IParticipation createEntity() {
		return new Participation();
	}

	protected ParticipationDaoImpl() {
		super(Participation.class);
	}

	@Override
	public List<IParticipation> find(ParticipationFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IParticipation> cq = cb.createQuery(IParticipation.class); // define
		// type
		// of
		// result
		final Root<Participation> from = cq.from(Participation.class);// select from brand
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Participation, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}

		final TypedQuery<IParticipation> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(ParticipationFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Participation> from = cq.from(Participation.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Participation, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Participation_.id;
		case "tournamentPoints":
			return Participation_.tournamentPoints;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
