package by.itacademy.karpuk.chess.dao.jdbc.entity;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Piece;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;

public class Board extends BaseEntity implements IBoard {
	private IGame game;
	private Piece piece;
	private String positionLetter;
	private Integer positionNumber;

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
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
