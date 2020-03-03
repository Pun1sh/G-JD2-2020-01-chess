package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IMoveDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.service.IMoveService;

@Service
public class MoveServiceImpl implements IMoveService {
	@Autowired
	private IMoveDao dao;

	@Override
	public IMove get(Integer id) {
		final IMove entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IMove> getAll() {
		final List<IMove> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IMove entity) {
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
	public IMove createEntity() {
		return dao.createEntity();
	}

}
