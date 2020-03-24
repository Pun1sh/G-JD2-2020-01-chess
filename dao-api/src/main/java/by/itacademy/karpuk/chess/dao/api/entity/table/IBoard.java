package by.itacademy.karpuk.chess.dao.api.entity.table;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Piece;

public interface IBoard extends IBaseEntity {
	IGame getGame();

	void setGame(IGame game);

	Piece getPiece();

	void setPiece(Piece piece);

	String getPositionLetter();

	void setPositionLetter(String positionLetter);

	Integer getPositionNumber();

	void setPositionNumber(Integer positionNumber);
}
