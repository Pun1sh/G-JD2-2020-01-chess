package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Piece;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

@Entity
public class Move extends BaseEntity implements IMove {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Game.class)
	private IGame game;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer player;
	@Enumerated(EnumType.STRING)
	private Piece piece;
	@Column
	private String moveNotationFrom;
	@Column
	private String moveNotationTo;
	@Column
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
