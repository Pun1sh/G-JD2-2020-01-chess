package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IMessageDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	@Autowired
	private IMessageDao dao;

	@Override
	public IMessage get(Integer id) {
		final IMessage entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IMessage> getAll() {
		final List<IMessage> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IMessage entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}

	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);

	}

	@Override
	public void deleteAll() {
		dao.deleteAll();

	}

	@Override
	public IMessage createEntity() {
		return dao.createEntity();
	}

}
