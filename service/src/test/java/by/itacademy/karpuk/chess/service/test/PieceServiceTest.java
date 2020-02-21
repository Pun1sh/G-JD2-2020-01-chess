package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;

public class PieceServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final IPiece entity = saveNewPiece();
		final IPiece entityFromDb = pieceService.get(entity.getId());
		assertNotNull(entityFromDb);
		assertEquals(entity.getName(), entityFromDb.getName());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = pieceService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewPiece();
		}

		final List<IPiece> allEntities = pieceService.getAll();

		for (final IPiece entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getId());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IPiece entity = saveNewPiece();
		pieceService.delete(entity.getId());
		assertNull(pieceService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewPiece();
		pieceService.deleteAll();
		assertEquals(0, pieceService.getAll().size());
	}
}
