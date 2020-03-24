package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.filter.CountryFilter;

public interface ICountryService {
	ICountry get(Integer id);

	List<ICountry> getAll();

	@Transactional
	void save(ICountry entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	ICountry createEntity();

	List<ICountry> find(CountryFilter filter);
}
