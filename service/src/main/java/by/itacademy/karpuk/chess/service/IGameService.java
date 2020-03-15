package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;

public interface IGameService {
	IGame get(Integer id);

	List<IGame> getAll();

	void save(IGame entity);

	void delete(Integer id);

	void deleteAll();

	IGame createEntity();

	List<IGame> find(GameFilter filter);
}
