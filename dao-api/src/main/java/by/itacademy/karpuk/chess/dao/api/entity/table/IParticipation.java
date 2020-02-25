package by.itacademy.karpuk.chess.dao.api.entity.table;

public interface IParticipation extends IBaseEntity {
	IPlayer getPlayer();

	void setPlayer(IPlayer player);

	ITournament getTournament();

	void setTournament(ITournament tournament);

	Integer getTournamentPoints();

	void setTournamentPoints(Integer tournamentPoints);

}
