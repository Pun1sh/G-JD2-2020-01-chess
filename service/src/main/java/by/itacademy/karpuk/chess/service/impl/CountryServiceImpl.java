package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.ICountryDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.jdbc.CountryDaoImpl;
import by.itacademy.karpuk.chess.service.ICountryService;

public class CountryServiceImpl implements ICountryService {
	private ICountryDao dao = new CountryDaoImpl();

	@Override
	public ICountry createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final ICountry entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public ICountry get(final Integer id) {
		final ICountry entity = dao.get(id);
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
	public List<ICountry> getAll() {
		final List<ICountry> all = dao.selectAll();
		return all;
	}
}
