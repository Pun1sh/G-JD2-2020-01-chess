package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.web.dto.CountryDTO;

@Component
public class CountryToDTOConverter implements Function<ICountry, CountryDTO> {
	@Override
	public CountryDTO apply(ICountry entity) {
		CountryDTO dto = new CountryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}
}
