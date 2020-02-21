package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

public interface IDao<ENTITY, ID> {

	ENTITY createEntity();

	ENTITY get(ID id);

	void insert(ENTITY entity);

	void update(final ENTITY entity);

	void delete(ID id);

	void deleteAll();

	List<ENTITY> selectAll();
}