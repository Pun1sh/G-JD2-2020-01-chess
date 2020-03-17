package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.service.IModeService;
import by.itacademy.karpuk.chess.web.dto.ModeDTO;

@Component
public class ModeFromDTOConverter implements Function<ModeDTO, IMode> {
	@Autowired
	private IModeService modeService;

	@Override
	public IMode apply(ModeDTO t) {
		IMode entity = modeService.createEntity();
		entity.setId(t.getId());
		entity.setName(t.getName());
		entity.setTimeMinutes(t.getTimeMinutes());
		return entity;
	}

}
