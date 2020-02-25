package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IParticipationDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.jdbc.ParticipationDaoImpl;
import by.itacademy.karpuk.chess.service.IParticipationService;

public class ParticipationServiceImpl implements IParticipationService {
	private IParticipationDao dao = new ParticipationDaoImpl();

	@Override
	public IParticipation get(Integer id) {
		final IParticipation entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IParticipation> getAll() {
		final List<IParticipation> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IParticipation entity) {
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
	public IParticipation createEntity() {
		return dao.createEntity();
	}

}