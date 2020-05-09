package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.web.dto.GameDTO;

@Component
public class GameToDTOConverter implements Function<IGame, GameDTO> {

	@Override
	public GameDTO apply(IGame t) {
		GameDTO dto = new GameDTO();
		dto.setId(t.getId());
		dto.setWhitePlayerId(t.getWhitePlayer().getId());
		dto.setBlackPlayerId(t.getBlackPlayer().getId());
		if (!(t.getTournament() == null)) {
			dto.setTournamentId(t.getTournament().getId());
		}
		if (!(t.getWinner() == null)) {
			dto.setWinnerId(t.getWinner().getId());
		}
		if (!(t.getLoser() == null)) {
			dto.setLoserId(t.getLoser().getId());
		}
		dto.setStarted(t.getStarted());
		if (!(t.getEnded() == null)) {
			dto.setEnded(t.getEnded());
		}
		dto.setMode(t.getMode());
		return dto;
	}

}
