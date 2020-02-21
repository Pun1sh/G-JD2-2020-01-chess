package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;

public interface IPieceService {

	IPiece get(Integer id);

	List<IPiece> getAll();

	void save(IPiece entity);

	void delete(Integer id);

	void deleteAll();

	IPiece createEntity();

}