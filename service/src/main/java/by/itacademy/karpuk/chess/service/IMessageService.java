package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;

public interface IMessageService {
	IMessage get(Integer id);

	List<IMessage> getAll();

	void save(IMessage entity);

	void delete(Integer id);

	void deleteAll();

	IMessage createEntity();
}
