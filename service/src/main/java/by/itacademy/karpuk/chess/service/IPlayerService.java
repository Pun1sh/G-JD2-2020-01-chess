package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;

public interface IPlayerService {
	IPlayer get(Integer id);

	List<IPlayer> getAll();

	void save(IPlayer entity);

	void delete(Integer id);

	void deleteAll();

	IPlayer createEntity();

	List<IPlayer> find(PlayerFilter filter);
}
