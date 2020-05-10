package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;

public interface IGameService {
	IGame get(Integer id);

	List<IGame> getAll();

	@Transactional
	void save(IGame entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IGame createEntity();

	List<IGame> find(GameFilter filter);

	IGame getFullInfo(Integer id);

	long getCount(GameFilter filter);
}
