package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IPieceDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.dao.api.filter.PieceFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Piece;

@Repository
public class PieceDaoImpl extends AbstractDaoImpl<IPiece, Integer> implements IPieceDao {

	@Override
	public IPiece createEntity() {
		return new Piece();
	}

	protected PieceDaoImpl() {
		super(Piece.class);
	}

	@Override
	public List<IPiece> find(PieceFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(PieceFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
