package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.filter.BoardFilter;

public class BoardServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		IBoard entity = saveNewBoard();

		final IBoard entityFromDb = boardService.getFullInfo(entity.getId());

		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getGame().getId());
		assertNotNull(entityFromDb.getFen());
		assertEquals(entity.getGame().getId(), entityFromDb.getGame().getId());
		assertEquals(entity.getFen(), entityFromDb.getFen());

	}

	@Test
	public void testGetAll() {
		final int intialCount = boardService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewBoard();
		}

		final List<IBoard> allEntities = boardService.find(new BoardFilter());

		for (final IBoard entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getGame().getId());
			assertNotNull(entityFromDb.getFen());
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
