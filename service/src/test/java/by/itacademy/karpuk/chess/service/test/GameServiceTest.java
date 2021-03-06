package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;

public class GameServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		IGame entity = saveNewGame();

		final IGame entityFromDb = gameService.getFullInfo(entity.getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getWhitePlayer().getId());
		assertNotNull(entityFromDb.getBlackPlayer().getId());
		assertNotNull(entityFromDb.getStarted());
		assertNotNull(entityFromDb.getMode());
		assertNotNull(entityFromDb.getHistoryOfMoves());

		assertEquals(entity.getWhitePlayer().getId(), entityFromDb.getWhitePlayer().getId());
		assertEquals(entity.getBlackPlayer().getId(), entityFromDb.getBlackPlayer().getId());
		assertEquals(entity.getWinner().getId(), entityFromDb.getWinner().getId());
		assertEquals(entity.getLoser().getId(), entityFromDb.getLoser().getId());
		assertEquals(entity.getStarted(), entityFromDb.getStarted());
		assertEquals(entity.getEnded(), entityFromDb.getEnded());
		assertEquals(entity.getMode(), entityFromDb.getMode());
		assertEquals(entity.getHistoryOfMoves(), entityFromDb.getHistoryOfMoves());

	}

	@Test
	public void testGetAll() {
		final int intialCount = gameService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewGame();
		}

		final List<IGame> allEntities = gameService.find(new GameFilter());

		for (final IGame entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getWhitePlayer().getId());
			assertNotNull(entityFromDb.getBlackPlayer().getId());
			assertNotNull(entityFromDb.getStarted());
			assertNotNull(entityFromDb.getMode());
			assertNotNull(entityFromDb.getHistoryOfMoves());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IGame entity = saveNewGame();
		gameService.delete(entity.getId());
		assertNull(gameService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewGame();
		gameService.deleteAll();
		assertEquals(0, gameService.getAll().size());
	}
}
