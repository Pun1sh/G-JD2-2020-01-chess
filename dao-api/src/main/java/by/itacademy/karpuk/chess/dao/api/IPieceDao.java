package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.dao.api.filter.PieceFilter;

public interface IPieceDao extends IDao<IPiece, Integer> {
	List<IPiece> find(PieceFilter filter);

	long getCount(PieceFilter filter);
}
