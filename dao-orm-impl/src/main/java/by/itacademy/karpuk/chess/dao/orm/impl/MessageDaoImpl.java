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

import by.itacademy.karpuk.chess.dao.api.IMessageDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.filter.MessageFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Message;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Message_;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<IMessage, Integer> implements IMessageDao {

	@Override
	public IMessage createEntity() {
		return new Message();
	}

	protected MessageDaoImpl() {
		super(Message.class);
	}

	@Override
	public List<IMessage> find(MessageFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IMessage> cq = cb.createQuery(IMessage.class); // define
																			// type
																			// of
		// result
		final Root<Message> from = cq.from(Message.class);// select from brand
		cq.select(from); // select what? select *
		from.fetch(Message_.writer, JoinType.LEFT);
		from.fetch(Message_.game, JoinType.LEFT);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Message, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); // build path to
																// sort
			// property
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order
																			// by
			// column_name
			// order
		}
		final TypedQuery<IMessage> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(MessageFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); // define
																	// type of
		// result
		final Root<Message> from = cq.from(Message.class); // select from mode
		cq.select(cb.count(from)); // select what? select count(*)
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); // execute query
	}

	private SingularAttribute<? super Message, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "id":
			return Message_.id;
		case "content":
			return Message_.content;
		case "created":
			return Message_.created;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public IMessage getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();

		final CriteriaQuery<IMessage> cq = cb.createQuery(IMessage.class); // define returning result
		final Root<Message> from = cq.from(Message.class); // define table for select

		cq.select(from); // define what need to be selected

		from.fetch(Message_.writer, JoinType.LEFT);
		from.fetch(Message_.game, JoinType.LEFT);

		// .. where id=...
		cq.where(cb.equal(from.get(Message_.id), id)); // where id=?

		final TypedQuery<IMessage> q = em.createQuery(cq);

		return q.getSingleResult();
	}

}
