package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Mode;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;

@Entity
public class Game extends BaseEntity implements IGame {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer whitePlayer;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer blackPlayer;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer winner;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer loser;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Tournament.class)
	private ITournament tournament;
	@Column
	private Date started;
	@Column
	private Date ended;
	@Enumerated(EnumType.STRING)
	private Mode mode;

	public IPlayer getWhitePlayer() {
		return whitePlayer;
	}

	public void setWhitePlayer(IPlayer whitePlayer) {
		this.whitePlayer = whitePlayer;
	}

	public IPlayer getBlackPlayer() {
		return blackPlayer;
	}

	public void setBlackPlayer(IPlayer blackPlayer) {
		this.blackPlayer = blackPlayer;
	}

	public IPlayer getWinner() {
		return winner;
	}

	public void setWinner(IPlayer winner) {
		this.winner = winner;
	}

	public IPlayer getLoser() {
		return loser;
	}

	public void setLoser(IPlayer loser) {
		this.loser = loser;
	}

	public ITournament getTournament() {
		return tournament;
	}

	public void setTournament(ITournament tournament) {
		this.tournament = tournament;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

}
