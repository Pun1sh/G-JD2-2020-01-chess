package by.itacademy.karpuk.chess.dao.api.entity.table;

public interface IBoard extends IBaseEntity {
	IGame getGame();

	void setGame(IGame game);

	String getFen();

	void setFen(String Fen);

}
