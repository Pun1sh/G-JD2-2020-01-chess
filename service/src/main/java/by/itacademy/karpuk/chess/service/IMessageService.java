package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;

public interface IMessageService {
	IMessage get(Integer id);

	List<IMessage> getAll();

	@Transactional
	void save(IMessage entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IMessage createEntity();
}
