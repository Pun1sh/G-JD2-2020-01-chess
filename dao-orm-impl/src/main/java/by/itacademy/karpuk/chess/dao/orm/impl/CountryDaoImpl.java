package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.ICountryDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.filter.CountryFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Country;

@Repository
public class CountryDaoImpl extends AbstractDaoImpl<ICountry, Integer> implements ICountryDao {
	@Override
	public ICountry createEntity() {
		return new Country();
	}

	protected CountryDaoImpl() {
		super(Country.class);
	}

	@Override
	public List<ICountry> find(CountryFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(CountryFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
