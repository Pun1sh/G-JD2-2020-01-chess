package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;

public interface IMoveService {
	IMove get(Integer id);

	List<IMove> getAll();

	void save(IMove entity);

	void delete(Integer id);

	void deleteAll();

	IMove createEntity();
}
