package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;

public interface IClubService {
	IClub get(Integer id);

	void save(IClub entity);

	void delete(Integer id);

	IClub createEntity();

	List<IClub> getAll();

	List<IClub> find(ClubFilter filter);

	long getCount(ClubFilter filter);

	void deleteAll();

}
