package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.filter.MessageFilter;

public interface IMessageDao extends IDao<IMessage, Integer> {
	List<IMessage> find(MessageFilter filter);

	long getCount(MessageFilter filter);
}
