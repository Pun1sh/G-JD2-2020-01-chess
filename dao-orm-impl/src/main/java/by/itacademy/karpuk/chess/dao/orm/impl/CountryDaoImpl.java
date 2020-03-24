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

import by.itacademy.karpuk.chess.dao.api.ICountryDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.filter.CountryFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Country;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Country_;

@Repository
public class CountryDaoImpl extends AbstractDaoImpl<ICountry, Integer> implements ICountryDao {
	@Override
	public ICountry createEntity() {
		return new Country();
	}

	protected CountryDaoImpl() {
		super(Country.class);
	}

	@Override
	public List<ICountry> find(CountryFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<ICountry> cq = cb.createQuery(ICountry.class); // define
																			// type
																			// of
		// result
		final Root<Country> from = cq.from(Country.class);// select from brand
		cq.select(from); // select what? select *

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Country, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}

		final TypedQuery<ICountry> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(CountryFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Country> from = cq.from(Country.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Country, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Country_.id;
		case "name":
			return Country_.name;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
