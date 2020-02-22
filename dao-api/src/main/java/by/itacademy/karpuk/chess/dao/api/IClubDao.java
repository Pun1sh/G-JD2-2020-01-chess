package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;

public interface IClubDao extends IDao<IClub, Integer> {
	List<IClub> find(ClubFilter filter);

	long getCount(ClubFilter filter);
}
