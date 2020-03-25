package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.filter.MoveFilter;

public interface IMoveDao extends IDao<IMove, Integer> {
	List<IMove> find(MoveFilter filter);

	long getCount(MoveFilter filter);

	IMove getFullInfo(Integer id);
}
