package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

public class Move extends BaseEntity implements IMove {
	private IGame game;
	private IPlayer player;
	private IPiece piece;
	private String moveNotationFrom;
	private String moveNotationTo;
	private Integer moveTime;

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}

	public IPlayer getPlayer() {
		return player;
	}

	public void setPlayer(IPlayer player) {
		this.player = player;
	}

	public IPiece getPiece() {
		return piece;
	}

	public void setPiece(IPiece piece) {
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
