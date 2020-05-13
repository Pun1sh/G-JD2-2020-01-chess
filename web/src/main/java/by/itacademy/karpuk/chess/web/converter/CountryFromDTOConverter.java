package by.itacademy.karpuk.chess.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.web.dto.CountryDTO;

@Component
public class CountryFromDTOConverter implements Function<CountryDTO, ICountry> {
	@Autowired
	ICountryService service;

	@Override
	public ICountry apply(CountryDTO input) {
		ICountry country = service.createEntity();
		country.setId(input.getId());
		country.setName(input.getName());
		return country;
	}

}
