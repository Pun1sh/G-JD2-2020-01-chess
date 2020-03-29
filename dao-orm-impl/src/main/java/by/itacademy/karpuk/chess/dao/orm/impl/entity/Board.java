package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;

@Entity
public class Board extends BaseEntity implements IBoard {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Game.class)
	private IGame game;
	@Column
	private String fen;

	public String getFen() {
		return fen;
	}

	public void setFen(String fen) {
		this.fen = fen;
	}

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}

}
