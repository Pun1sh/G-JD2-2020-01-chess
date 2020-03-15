package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.web.dto.ClubDTO;

@Component
public class ClubToDTOConverter implements Function<IClub, ClubDTO> {

	@Override
	public ClubDTO apply(IClub t) {
		ClubDTO dto = new ClubDTO();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setCreatedDate(t.getCreatedDate());
		dto.setDeletedDate(t.getDeletedDate());
		dto.setNumberOfMembers(t.getNumberOfMembers());
		dto.setCountryId(t.getCountry().getId());
		return dto;
	}

}
