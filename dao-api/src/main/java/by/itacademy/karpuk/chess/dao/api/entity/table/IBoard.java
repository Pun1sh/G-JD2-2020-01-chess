package by.itacademy.karpuk.chess.dao.api.entity.table;

public interface IBoard extends IBaseEntity {
	IGame getGame();

	void setGame(IGame game);

	IPiece getPiece();

	void setPiece(IPiece piece);

	String getPositionLetter();

	void setPositionLetter(String positionLetter);

	Integer getPositionNumber();

	void setPositionNumber(Integer positionNumber);
}
