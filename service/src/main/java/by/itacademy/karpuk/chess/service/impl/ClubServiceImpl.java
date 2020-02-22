package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IClubDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;
import by.itacademy.karpuk.chess.dao.jdbc.ClubDaoImpl;
import by.itacademy.karpuk.chess.service.IClubService;

public class ClubServiceImpl implements IClubService {
	private IClubDao dao = new ClubDaoImpl();

	@Override
	public IClub get(Integer id) {
		final IClub entity = dao.get(id);
		return entity;
	}

	@Override
	public void save(IClub entity) {
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
	public IClub createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IClub> getAll() {
		final List<IClub> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IClub> find(ClubFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(ClubFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

}
