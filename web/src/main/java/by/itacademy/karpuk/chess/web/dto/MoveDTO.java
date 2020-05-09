package by.itacademy.karpuk.chess.web.dto;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Piece;

public class MoveDTO {
	private Integer id;
	private Integer gameId;
	private Integer playerId;
	private Piece piece;
	private String moveNotationFrom;
	private String moveNotationTo;
	private Integer moveTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public String getMoveNotationFrom() {
		return moveNotationFrom;
	}

	public void setMoveNotationFrom(String moveNotationFrom) {
		this.moveNotationFrom = moveNotationFrom;
	}

	public String getMoveNotationTo() {
		return moveNotationTo;
	}

	public void setMoveNotationTo(String moveNotationTo) {
		this.moveNotationTo = moveNotationTo;
	}

	public Integer getMoveTime() {
		return moveTime;
	}

	public void setMoveTime(Integer moveTime) {
		this.moveTime = moveTime;
	}

}
