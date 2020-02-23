package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IPlayerDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.jdbc.PlayerDaoImpl;
import by.itacademy.karpuk.chess.service.IPlayerService;

public class PlayerServiceImpl implements IPlayerService {
	private IPlayerDao dao = new PlayerDaoImpl();

	@Override
	public IPlayer get(Integer id) {
		final IPlayer entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IPlayer> getAll() {
		final List<IPlayer> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IPlayer entity) {
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
	public IPlayer createEntity() {
		return dao.createEntity();
	}

}
