package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

@Entity
public class Player extends BaseEntity implements IPlayer {
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String nickname;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	private ICountry country;
	@Column
	private Date registrated;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Club.class)
	private IClub club;
	@Column
	private Integer gamesPlayed;
	@Column
	private Date birthDate;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Integer eloPoints;
	@Column
	private String rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public ICountry getCountry() {
		return country;
	}

	public void setCountry(ICountry country) {
		this.country = country;
	}

	public Date getRegistrated() {
		return registrated;
	}

	public void setRegistrated(Date registrated) {
		this.registrated = registrated;
	}

	public IClub getClub() {
		return club;
	}

	public void setClub(IClub club) {
		this.club = club;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEloPoints() {
		return eloPoints;
	}

	public void setEloPoints(Integer eloPoints) {
		this.eloPoints = eloPoints;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}


}
