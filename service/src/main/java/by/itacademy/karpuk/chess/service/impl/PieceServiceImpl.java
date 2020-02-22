package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IPieceDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.dao.jdbc.PieceDaoImpl;
import by.itacademy.karpuk.chess.service.IPieceService;

public class PieceServiceImpl implements IPieceService {
	private IPieceDao dao = new PieceDaoImpl();

	@Override
	public IPiece createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IPiece entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public IPiece get(final Integer id) {
		final IPiece entity = dao.get(id);
		return entity;
	}

	@Override
	public void delete(final Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public List<IPiece> getAll() {
		final List<IPiece> all = dao.selectAll();
		return all;
	}

}