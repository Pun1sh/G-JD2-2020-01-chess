package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.web.dto.TournamentDTO;

@Component
public class TournamentToDTOConverter implements Function<ITournament, TournamentDTO> {

	@Override
	public TournamentDTO apply(ITournament t) {
		TournamentDTO dto = new TournamentDTO();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setStarted(t.getStarted());
		dto.setEnded(t.getEnded());
		dto.setCountryId(t.getCountry().getId());
		dto.setWinnerId(t.getWinner().getId());
		return dto;
	}

}
