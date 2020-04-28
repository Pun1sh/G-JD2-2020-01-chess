package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IPlayerDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.service.IPlayerService;

@Service
public class PlayerServiceImpl implements IPlayerService {
	@Autowired
	private IPlayerDao dao;

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

	@Override
	public List<IPlayer> find(PlayerFilter filter) {
		return dao.find(filter);
	}

	@Override
	public IPlayer getFullInfo(final Integer id) {
		return dao.getFullInfo(id);
	}

	@Override
	public IPlayer getPlayerByNickname(String nickname) {
		return dao.getPlayerByNickname(nickname);
	}

}
