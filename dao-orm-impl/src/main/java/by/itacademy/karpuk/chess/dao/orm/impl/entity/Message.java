package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import java.util.Date;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

public class Message extends BaseEntity implements IMessage {
	private IPlayer writer;
	private String content;
	private Date created;
	private IGame game;

	public IPlayer getWriter() {
		return writer;
	}

	public void setWriter(IPlayer writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}
}
