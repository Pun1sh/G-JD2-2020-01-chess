package by.itacademy.karpuk.chess.dao.api.entity.table;

import java.util.Date;

public interface IPlayer extends IBaseEntity {

	String getNickname();

	void setNickname(String nickname);

	ICountry getCountry();

	void setCountry(ICountry country);

	IClub getClub();

	void setClub(IClub club);

	Date getRegistrated();

	void setRegistrated(Date registratedDate);

	Integer getGamesPlayed();

	void setGamesPlayed(Integer gamesPlayed);

	Date getBirthDate();

	void setBirthDate(Date birthDate);

	String getEmail();

	void setEmail(String email);

	String getPassword();

	void setPassword(String password);

	Integer getEloPoints();

	void setEloPoints(Integer eloPoints);

	String getRank();

	void setRank(String rank);
}
