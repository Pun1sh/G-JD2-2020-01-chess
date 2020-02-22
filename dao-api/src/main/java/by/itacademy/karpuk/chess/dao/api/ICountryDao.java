package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.filter.CountryFilter;

public interface ICountryDao extends IDao<ICountry, Integer> {
	List<ICountry> find(CountryFilter filter);

	long getCount(CountryFilter filter);
}
