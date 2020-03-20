package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IGameDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Game;

@Repository
public class GameDaoImpl extends AbstractDaoImpl<IGame, Integer> implements IGameDao {

	@Override
	public IGame createEntity() {
		return new Game();
	}

	protected GameDaoImpl() {
		super(Game.class);
	}

	@Override
	public List<IGame> find(GameFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(GameFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
