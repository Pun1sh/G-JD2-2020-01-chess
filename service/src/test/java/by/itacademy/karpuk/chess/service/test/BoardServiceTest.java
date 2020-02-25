package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;

public class BoardServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IBoard entity = boardService.createEntity();
		entity.setGame(saveNewGame());
		entity.setPiece(saveNewPiece());
		boardService.save(entity);

		final IBoard entityFromDb = boardService.get(entity.getId());

		assertEquals(entity.getGame().getId(), entityFromDb.getGame().getId());
		assertEquals(entity.getPiece().getId(), entityFromDb.getPiece().getId());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = boardService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewBoard();
		}

		final List<IBoard> allEntities = boardService.getAll();

		for (final IBoard entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IBoard entity = saveNewBoard();
		boardService.delete(entity.getId());
		assertNull(boardService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewBoard();
		boardService.deleteAll();
		assertEquals(0, boardService.getAll().size());
	}
}