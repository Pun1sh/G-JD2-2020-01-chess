package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.filter.ModeFilter;

public interface IModeService {

	IMode get(Integer id);

	List<IMode> getAll();

	@Transactional
	void save(IMode entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IMode createEntity();

	List<IMode> find(ModeFilter filter);

	long getCount(ModeFilter filter);
}
