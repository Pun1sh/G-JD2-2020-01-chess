package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;

public class Board extends BaseEntity implements IBoard {
	private IGame game;
	private IPiece piece;
	private String positionLetter;
	private Integer positionNumber;

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}

	public IPiece getPiece() {
		return piece;
	}

	public void setPiece(IPiece piece) {
		this.piece = piece;
	}

	public String getPositionLetter() {
		return positionLetter;
	}

	public void setPositionLetter(String positionLetter) {
		this.positionLetter = positionLetter;
	}

	public Integer getPositionNumber() {
		return positionNumber;
	}

	public void setPositionNumber(Integer positionNumber) {
		this.positionNumber = positionNumber;
	}

}
