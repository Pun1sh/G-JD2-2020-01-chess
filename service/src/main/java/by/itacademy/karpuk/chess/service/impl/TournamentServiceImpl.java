package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.ITournamentDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;
import by.itacademy.karpuk.chess.service.ITournamentService;

@Service
public class TournamentServiceImpl implements ITournamentService {
	@Autowired
	private ITournamentDao dao;

	@Override
	public ITournament get(Integer id) {
		final ITournament entity = dao.get(id);
		return entity;
	}

	@Override
	public List<ITournament> getAll() {
		final List<ITournament> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(ITournament entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}

	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);

	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public ITournament createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<ITournament> find(TournamentFilter filter) {
		return dao.find(filter);
	}

	@Override
	public ITournament getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}

}
