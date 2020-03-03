package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IBoardDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.service.IBoardService;

@Service
public class BoardServiceImpl implements IBoardService {
	@Autowired
	private IBoardDao dao;

	@Override
	public IBoard get(Integer id) {
		final IBoard entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IBoard> getAll() {
		final List<IBoard> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IBoard entity) {
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
	public IBoard createEntity() {
		return dao.createEntity();
	}

}
