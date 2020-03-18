package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.web.dto.ParticipationDTO;

@Component
public class ParticipationToDTOConverter implements Function<IParticipation, ParticipationDTO> {

	@Override
	public ParticipationDTO apply(IParticipation t) {
		ParticipationDTO dto = new ParticipationDTO();
		dto.setId(t.getId());
		dto.setPlayerId(t.getPlayer().getId());
		dto.setTournamentId(t.getTournament().getId());
		dto.setTournamentPoints(t.getTournamentPoints());
		return dto;
	}
}
