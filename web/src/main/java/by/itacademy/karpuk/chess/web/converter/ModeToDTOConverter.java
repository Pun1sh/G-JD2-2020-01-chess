package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.web.dto.ModeDTO;

@Component
public class ModeToDTOConverter implements Function<IMode, ModeDTO> {

	@Override
	public ModeDTO apply(IMode entity) {
		ModeDTO dto = new ModeDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setTimeMinutes(entity.getTimeMinutes());
		return dto;
	}

}
