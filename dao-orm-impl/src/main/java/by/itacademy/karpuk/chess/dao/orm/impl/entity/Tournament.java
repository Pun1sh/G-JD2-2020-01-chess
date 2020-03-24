package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;

@Entity
public class Tournament extends BaseEntity implements ITournament {
	@Column
	private String name;
	@Column
	private Date started;
	@Column
	private Date ended;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	private ICountry country;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Player.class)
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
