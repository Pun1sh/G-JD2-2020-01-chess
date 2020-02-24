package by.itacademy.karpuk.chess.dao.api.entity.table;

public interface IMove extends IBaseEntity {
	IGame getGame();

	void setGame(IGame game);

	IPlayer getPlayer();

	void setPlayer(IPlayer player);

	IPiece getPiece();

	void setPiece(IPiece piece);

	String getMoveNotationFrom();

	void setMoveNotationFrom(String moveNotationFrom);

	String getMoveNotationTo();

	void setMoveNotationTo(String moveNotationTo);

	Integer getMoveTime();

	void setMoveTime(Integer moveTime);
}
