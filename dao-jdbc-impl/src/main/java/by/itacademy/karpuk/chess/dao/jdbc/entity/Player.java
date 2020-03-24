package by.itacademy.karpuk.chess.dao.jdbc.entity;

import java.util.Date;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

public class Player extends BaseEntity implements IPlayer {
	private String name;
	private String surname;
	private String nickname;
	private ICountry country;
	private Date registrated;
	private IClub club;
	private Integer gamesPlayed;
	private Date birthDate;
	private String email;
	private String password;
	private Integer eloPoints;
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
