package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;

public class Participation extends BaseEntity implements IParticipation {
	private IPlayer player;
	private ITournament tournament;
	private Integer tournamentPoints;

	public IPlayer getPlayer() {
		return player;
	}

	public void setPlayer(IPlayer player) {
		this.player = player;
	}

	public ITournament getTournament() {
		return tournament;
	}

	public void setTournament(ITournament tournament) {
		this.tournament = tournament;
	}

	public Integer getTournamentPoints() {
		return tournamentPoints;
	}

	public void setTournamentPoints(Integer tournamentPoints) {
		this.tournamentPoints = tournamentPoints;
	}

	@Override
	public String toString() {
		return "Participation [player=" + player + ", tournament=" + tournament + ", tournamentPoints="
				+ tournamentPoints + "]";
	}

}
