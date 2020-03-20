package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IMessageDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.filter.MessageFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Message;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(MessageFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
