package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IBoardDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.filter.BoardFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Board;

@Repository
public class BoardDaoImpl extends AbstractDaoImpl<IBoard, Integer> implements IBoardDao {

	@Override
	public IBoard createEntity() {
		return new Board();
	}

	protected BoardDaoImpl() {
		super(Board.class);
	}

	@Override
	public List<IBoard> find(BoardFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(BoardFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
