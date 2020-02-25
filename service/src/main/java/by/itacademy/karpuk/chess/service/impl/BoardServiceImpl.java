package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IBoardDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.jdbc.BoardDaoImpl;
import by.itacademy.karpuk.chess.service.IBoardService;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao = new BoardDaoImpl();

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
