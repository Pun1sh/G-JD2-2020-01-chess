package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IModeDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.jdbc.ModeDaoImpl;
import by.itacademy.karpuk.chess.service.IModeService;

public class ModeServiceImpl implements IModeService {
	private IModeDao dao = new ModeDaoImpl();

	@Override
	public IMode createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IMode entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public IMode get(final Integer id) {
		final IMode entity = dao.get(id);
		return entity;
	}

	@Override
	public void delete(final Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public List<IMode> getAll() {
		final List<IMode> all = dao.selectAll();
		return all;
	}
}