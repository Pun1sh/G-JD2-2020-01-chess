package by.itacademy.karpuk.chess.dao.jdbc.entity;

import java.util.Date;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;

public class Tournament extends BaseEntity implements ITournament {
	private String name;
	private Date started;
	private Date ended;
	private ICountry country;
	private IPlayer winner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public ICountry getCountry() {
		return country;
	}

	public void setCountry(ICountry country) {
		this.country = country;
	}

	public IPlayer getWinner() {
		return winner;
	}

	public void setWinner(IPlayer winner) {
		this.winner = winner;
	}

}
