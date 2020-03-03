package by.itacademy.karpuk.chess.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.karpuk.chess.dao.api.IPieceDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.service.IPieceService;

@Service
public class PieceServiceImpl implements IPieceService {
	private static Logger LOGGER = LoggerFactory.getLogger(PieceServiceImpl.class);
	@Autowired
	private IPieceDao dao;

	@Override
	public IPiece createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IPiece entity) {
		if (entity.getId() == null) {
			LOGGER.info("new piece created: {}", entity);
			dao.insert(entity);
		} else {
			LOGGER.debug("piece updated: {}", entity);
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
