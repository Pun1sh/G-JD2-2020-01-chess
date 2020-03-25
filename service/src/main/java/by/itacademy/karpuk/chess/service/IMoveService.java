package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.filter.MoveFilter;

public interface IMoveService {
	IMove get(Integer id);

	List<IMove> getAll();

	@Transactional
	void save(IMove entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IMove createEntity();

	List<IMove> find(MoveFilter filter);

	IMove getFullInfo(Integer id);
}
