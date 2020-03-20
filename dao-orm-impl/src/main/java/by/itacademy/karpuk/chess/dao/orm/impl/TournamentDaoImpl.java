package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.ITournamentDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Tournament;

@Repository
public class TournamentDaoImpl extends AbstractDaoImpl<ITournament, Integer> implements ITournamentDao {

	@Override
	public ITournament createEntity() {
		return new Tournament();
	}

	protected TournamentDaoImpl() {
		super(Tournament.class);
	}

	@Override
	public List<ITournament> find(TournamentFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(TournamentFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}
}
