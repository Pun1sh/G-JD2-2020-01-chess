package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;

public interface IGameDao extends IDao<IGame, Integer> {
	List<IGame> find(GameFilter filter);

	long getCount(GameFilter filter);

	IGame getFullInfo(Integer id);

}
