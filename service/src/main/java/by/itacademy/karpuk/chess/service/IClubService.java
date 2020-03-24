package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;

public interface IClubService {
	IClub get(Integer id);

	@Transactional
	void save(IClub entity);

	@Transactional
	void delete(Integer id);

	IClub createEntity();

	List<IClub> getAll();

	List<IClub> find(ClubFilter filter);

	long getCount(ClubFilter filter);

	@Transactional
	void deleteAll();

}
