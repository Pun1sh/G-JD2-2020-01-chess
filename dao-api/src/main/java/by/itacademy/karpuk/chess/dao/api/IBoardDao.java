package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.filter.BoardFilter;

public interface IBoardDao extends IDao<IBoard, Integer> {
	List<IBoard> find(BoardFilter filter);

	long getCount(BoardFilter filter);
}
