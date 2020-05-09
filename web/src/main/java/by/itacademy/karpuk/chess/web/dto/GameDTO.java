package by.itacademy.karpuk.chess.web.dto;

import java.util.Date;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Mode;

public class GameDTO {
	private Integer id;
	private Integer whitePlayerId;
	private Integer blackPlayerId;
	private Integer winnerId;
	private Integer loserId;
	private Integer tournamentId;
	private Date started;
	private Date ended;
	private Mode mode;
	private String whitePlayerName;
	private String blackPlayerName;
	private String winnerName;
	private String loserName;
	private String tournamentName;

	public String getWhitePlayerName() {
		return whitePlayerName;
	}

	public void setWhitePlayerName(String whitePlayerName) {
		this.whitePlayerName = whitePlayerName;
	}

	public String getBlackPlayerName() {
		return blackPlayerName;
	}

	public void setBlackPlayerName(String blackPlayerName) {
		this.blackPlayerName = blackPlayerName;
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

	public String getLoserName() {
		return loserName;
	}

	public void setLoserName(String loserName) {
		this.loserName = loserName;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWhitePlayerId() {
		return whitePlayerId;
	}

	public void setWhitePlayerId(Integer whitePlayerId) {
		this.whitePlayerId = whitePlayerId;
	}

	public Integer getBlackPlayerId() {
		return blackPlayerId;
	}

	public void setBlackPlayerId(Integer blackPlayerId) {
		this.blackPlayerId = blackPlayerId;
	}

	public Integer getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}

	public Integer getLoserId() {
		return loserId;
	}

	public void setLoserId(Integer loserId) {
		this.loserId = loserId;
	}

	public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
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

}
