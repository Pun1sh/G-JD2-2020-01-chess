package by.itacademy.karpuk.chess.service.test;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.service.IPieceService;
import by.itacademy.karpuk.chess.service.impl.PieceServiceImpl;

public class AbstractTest {
	protected IPieceService pieceService = new PieceServiceImpl();

	private static final Random RANDOM = new Random();

	@BeforeEach
	public void setUpMethod() {
		pieceService.deleteAll();

	}

	protected String getRandomPrefix() {
		return RANDOM.nextInt(99999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(9) + 1;
	}

	public Random getRANDOM() {
		return RANDOM;
	}

	protected IPiece saveNewPiece() {
		final IPiece entity = pieceService.createEntity();
		entity.setName("piece-" + getRandomPrefix());
		pieceService.save(entity);
		return entity;
	}
}
