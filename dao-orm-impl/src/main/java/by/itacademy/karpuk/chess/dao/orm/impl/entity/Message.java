package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

@Entity
public class Message extends BaseEntity implements IMessage {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
	private IPlayer writer;
	@Column
	private String content;
	@Column
	private Date created;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Game.class)
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
