package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;

public interface ITournamentService {
	ITournament get(Integer id);

	List<ITournament> getAll();

	@Transactional
	void save(ITournament entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	ITournament createEntity();

	List<ITournament> find(TournamentFilter filter);

	ITournament getFullInfo(Integer id);
}
