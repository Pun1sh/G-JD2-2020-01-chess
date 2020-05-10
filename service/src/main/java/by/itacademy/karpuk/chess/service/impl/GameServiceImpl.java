package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IGameDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;
import by.itacademy.karpuk.chess.service.IGameService;

@Service
public class GameServiceImpl implements IGameService {
	@Autowired
	private IGameDao dao;

	@Override
	public IGame get(Integer id) {
		final IGame entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IGame> getAll() {
		final List<IGame> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IGame entity) {
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
	public IGame createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IGame> find(GameFilter filter) {
		return dao.find(filter);
	}

	@Override
	public IGame getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}

	@Override
	public long getCount(GameFilter filter) {
		return dao.getCount(filter);
	}

}
