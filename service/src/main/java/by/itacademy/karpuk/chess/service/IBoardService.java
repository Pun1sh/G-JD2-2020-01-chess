package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.filter.BoardFilter;

public interface IBoardService {
	IBoard get(Integer id);

	List<IBoard> getAll();

	@Transactional
	void save(IBoard entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IBoard createEntity();

	IBoard getFullInfo(Integer id);

	List<IBoard> find(BoardFilter boardFilter);

	IBoard getNewestBoard(Integer gameId);
}
