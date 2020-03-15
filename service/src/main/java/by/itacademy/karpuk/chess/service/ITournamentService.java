package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;

public interface ITournamentService {
	ITournament get(Integer id);

	List<ITournament> getAll();

	void save(ITournament entity);

	void delete(Integer id);

	void deleteAll();

	ITournament createEntity();

	List<ITournament> find(TournamentFilter filter);
}
