package by.itacademy.karpuk.chess.dao.api.entity.table;

public interface IMove extends IBaseEntity {
	IGame getGame();

	void setGame(IGame game);

	IPlayer getPlayer();

	void setPlayer(IPlayer player);

	by.itacademy.karpuk.chess.dao.api.entity.enums.Piece getPiece();

	void setPiece(by.itacademy.karpuk.chess.dao.api.entity.enums.Piece piece);

	String getMoveNotationFrom();

	void setMoveNotationFrom(String moveNotationFrom);

	String getMoveNotationTo();

	void setMoveNotationTo(String moveNotationTo);

	Integer getMoveTime();

	void setMoveTime(Integer moveTime);
}
