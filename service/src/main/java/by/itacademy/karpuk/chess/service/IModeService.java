package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;

public interface IModeService {

	IMode get(Integer id);

	List<IMode> getAll();

	void save(IMode entity);

	void delete(Integer id);

	void deleteAll();

	IMode createEntity();
}
