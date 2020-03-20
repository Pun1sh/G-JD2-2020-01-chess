package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IPlayerDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Player;

@Repository
public class PlayerDaoImpl extends AbstractDaoImpl<IPlayer, Integer> implements IPlayerDao {

	@Override
	public IPlayer createEntity() {
		return new Player();
	}

	protected PlayerDaoImpl() {
		super(Player.class);
	}

	@Override
	public List<IPlayer> find(PlayerFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(PlayerFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
