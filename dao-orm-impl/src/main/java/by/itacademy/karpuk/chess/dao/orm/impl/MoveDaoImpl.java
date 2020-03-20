package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IMoveDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.filter.MoveFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Move;

@Repository
public class MoveDaoImpl extends AbstractDaoImpl<IMove, Integer> implements IMoveDao {

	@Override
	public IMove createEntity() {
		return new Move();
	}

	protected MoveDaoImpl() {
		super(Move.class);
	}

	@Override
	public List<IMove> find(MoveFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(MoveFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}
}
