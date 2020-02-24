package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;

public class MoveServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IMove entity = moveService.createEntity();
		entity.setGame(saveNewGame());
		entity.setPiece(saveNewPiece());
		entity.setPlayer(saveNewPlayer());
		moveService.save(entity);

		final IMove entityFromDb = moveService.get(entity.getId());

		assertEquals(entity.getGame().getId(), entityFromDb.getGame().getId());
		assertEquals(entity.getPiece().getId(), entityFromDb.getPiece().getId());
		assertEquals(entity.getPlayer().getId(), entityFromDb.getPlayer().getId());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = moveService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewMove();
		}

		final List<IMove> allEntities = moveService.getAll();

		for (final IMove entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IMove entity = saveNewMove();
		moveService.delete(entity.getId());
		assertNull(moveService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewMove();
		moveService.deleteAll();
		assertEquals(0, moveService.getAll().size());
	}
}
