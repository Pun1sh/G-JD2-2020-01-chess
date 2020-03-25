package by.itacademy.karpuk.chess.dao.api.entity.table;

import java.util.Date;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Mode;

public interface IGame extends IBaseEntity {
	IPlayer getWhitePlayer();

	void setWhitePlayer(IPlayer whitePlayer);

	IPlayer getBlackPlayer();

	void setBlackPlayer(IPlayer blackPlayer);

	ITournament getTournament();

	void setTournament(ITournament tournament);

	IPlayer getWinner();

	void setWinner(IPlayer winner);

	IPlayer getLoser();

	void setLoser(IPlayer loser);

	Date getStarted();

	void setStarted(Date started);

	Date getEnded();

	void setEnded(Date ended);

	Mode getMode();

	void setMode(Mode mode);

}
