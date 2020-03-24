package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;

public interface IPieceService {

	IPiece get(Integer id);

	List<IPiece> getAll();

	@Transactional
	void save(IPiece entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IPiece createEntity();

}