package by.itacademy.karpuk.chess.web.dto;

import java.util.Date;

public class PlayerDTO {
	private Integer id;
	private String nickname;
	private Integer countryId;
	private Date registrated;
	private Integer clubId;
	private Integer gamesPlayed;
	private Date birthDate;
	private String email;
	private String password;
	private Integer eloPoints;
	private String rank;
	private String salt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Date getRegistrated() {
		return registrated;
	}

	public void setRegistrated(Date registrated) {
		this.registrated = registrated;
	}

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
