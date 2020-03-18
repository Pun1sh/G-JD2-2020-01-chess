package by.itacademy.karpuk.chess.web.dto;

public class ParticipationDTO {
	private Integer id;
	private Integer playerId;
	private Integer tournamentId;
	private Integer tournamentPoints;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Integer getTournamentPoints() {
		return tournamentPoints;
	}

	public void setTournamentPoints(Integer tournamentPoints) {
		this.tournamentPoints = tournamentPoints;
	}

}
