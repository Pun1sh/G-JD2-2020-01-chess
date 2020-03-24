package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;

public interface IPlayerDao extends IDao<IPlayer, Integer> {
	List<IPlayer> find(PlayerFilter filter);

	long getCount(PlayerFilter filter);

	IPlayer getFullInfo(Integer id);
}
