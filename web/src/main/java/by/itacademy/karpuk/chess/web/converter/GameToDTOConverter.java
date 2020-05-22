package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.web.dto.GameDTO;

@Component
public class GameToDTOConverter implements Function<IGame, GameDTO> {

	@Override
	public GameDTO apply(IGame t) {
		GameDTO dto = new GameDTO();
		dto.setId(t.getId());
		dto.setWhitePlayerId(t.getWhitePlayer().getId());
		dto.setBlackPlayerId(t.getBlackPlayer().getId());
		if (t.getTournament() != null) {
			dto.setTournamentId(t.getTournament().getId());
		}
		if (t.getWinner() != null) {
			dto.setWinnerId(t.getWinner().getId());
		}
		if (t.getLoser() != null) {
			dto.setLoserId(t.getLoser().getId());
		}
		dto.setStarted(t.getStarted());
		if (t.getEnded() != null) {
			dto.setEnded(t.getEnded());
		}
		dto.setMode(t.getMode());
		IPlayer whitePlayer = t.getWhitePlayer();
		IPlayer blackPlayer = t.getBlackPlayer();
		IPlayer winner = t.getWinner();
		IPlayer loser = t.getLoser();
		ITournament tournament = t.getTournament();
		if (whitePlayer != null && blackPlayer != null) {
			dto.setBlackPlayerName(blackPlayer.getNickname());
			dto.setWhitePlayerName(whitePlayer.getNickname());
		}
		if (loser != null && winner != null) {
			dto.setLoserName(loser.getNickname());
			dto.setWinnerName(winner.getNickname());

		}
		if (tournament != null) {
			dto.setTournamentName(tournament.getName());
		}

		return dto;
	}

}
