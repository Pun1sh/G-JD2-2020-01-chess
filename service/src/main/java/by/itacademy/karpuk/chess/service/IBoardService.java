package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;

public interface IBoardService {
	IBoard get(Integer id);

	List<IBoard> getAll();

	void save(IBoard entity);

	void delete(Integer id);

	void deleteAll();

	IBoard createEntity();
}
