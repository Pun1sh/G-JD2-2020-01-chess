package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;

@Entity
public class Participation extends BaseEntity implements IParticipation {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer player;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Tournament.class)
	private ITournament tournament;
	@Column
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
