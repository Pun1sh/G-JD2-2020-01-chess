package by.itacademy.karpuk.chess.dao.api.entity.table;

import java.util.Date;

public interface IMessage extends IBaseEntity {
	IPlayer getWriter();

	void setWriter(IPlayer writer);

	String getContent();

	void setContent(String content);

	Date getCreated();

	void setCreated(Date created);

	IGame getGame();

	void setGame(IGame game);
}
