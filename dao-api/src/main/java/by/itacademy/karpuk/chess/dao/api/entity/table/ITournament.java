package by.itacademy.karpuk.chess.dao.api.entity.table;

import java.util.Date;

public interface ITournament extends IBaseEntity {
	String getName();

	void setName(String name);

	Date getStarted();

	void setStarted(Date started);

	Date getEnded();

	void setEnded(Date ended);

	ICountry getCountry();

	void setCountry(ICountry country);

	IPlayer getWinner();

	void setWinner(IPlayer winner);

}
