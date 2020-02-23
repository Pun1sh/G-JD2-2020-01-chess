package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;

public interface ITournamentDao extends IDao<ITournament, Integer> {
	List<ITournament> find(TournamentFilter filter);

	long getCount(TournamentFilter filter);
}
