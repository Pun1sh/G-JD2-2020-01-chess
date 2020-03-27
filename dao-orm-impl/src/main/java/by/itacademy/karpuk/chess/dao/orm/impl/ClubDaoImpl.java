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

import by.itacademy.karpuk.chess.dao.api.IClubDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Club;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Club_;

@Repository
public class ClubDaoImpl extends AbstractDaoImpl<IClub, Integer> implements IClubDao {

	@Override
	public IClub createEntity() {
		return new Club();
	}

	protected ClubDaoImpl() {
		super(Club.class);
	}

	@Override
	public List<IClub> find(ClubFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IClub> cq = cb.createQuery(IClub.class); // define
																		// type
																		// of
		// result
		final Root<Club> from = cq.from(Club.class);// select from brand
		cq.select(from); // select what? select *
		from.fetch(Club_.country, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Club, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}

		final TypedQuery<IClub> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(ClubFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Club> from = cq.from(Club.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Club, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Club_.id;
		case "name":
			return Club_.name;
		case "created":
			return Club_.created;
		case "deleted":
			return Club_.deleted;
		case "numberOfMembers":
			return Club_.numberOfMembers;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
