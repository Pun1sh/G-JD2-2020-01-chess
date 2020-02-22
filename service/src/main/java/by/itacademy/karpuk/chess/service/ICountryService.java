package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;

public interface ICountryService {
	ICountry get(Integer id);

	List<ICountry> getAll();

	void save(ICountry entity);

	void delete(Integer id);

	void deleteAll();

	ICountry createEntity();
}
