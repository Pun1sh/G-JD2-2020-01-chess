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

import by.itacademy.karpuk.chess.dao.api.ITournamentDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Player_;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Tournament;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Tournament_;

@Repository
public class TournamentDaoImpl extends AbstractDaoImpl<ITournament, Integer> implements ITournamentDao {

	@Override
	public ITournament createEntity() {
		return new Tournament();
	}

	protected TournamentDaoImpl() {
		super(Tournament.class);
	}

	@Override
	public List<ITournament> find(TournamentFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<ITournament> cq = cb.createQuery(ITournament.class); // define
		// type
		// of
		// result
		final Root<Tournament> from = cq.from(Tournament.class);// select from brand
		cq.select(from); // select what? select *
		from.fetch(Tournament_.country, JoinType.LEFT);
		from.fetch(Tournament_.winner, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Tournament, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}

		final TypedQuery<ITournament> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(TournamentFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Tournament> from = cq.from(Tournament.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Tournament, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Tournament_.id;
		case "name":
			return Tournament_.name;
		case "ended":
			return Tournament_.ended;
		case "started":
			return Tournament_.started;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public ITournament getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<ITournament> cq = cb.createQuery(ITournament.class); // define returning result
		final Root<Tournament> from = cq.from(Tournament.class); // define table for select

		cq.select(from); // define what need to be selected

		from.fetch(Tournament_.country, JoinType.LEFT);
		from.fetch(Tournament_.winner, JoinType.LEFT);

		// .. where id=...
		cq.where(cb.equal(from.get(Player_.id), id)); // where id=?

		final TypedQuery<ITournament> q = em.createQuery(cq);

		return q.getSingleResult();
	}
}
