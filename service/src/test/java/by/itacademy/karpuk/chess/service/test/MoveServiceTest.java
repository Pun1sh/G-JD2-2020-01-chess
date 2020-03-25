package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.filter.MoveFilter;

public class MoveServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IMove entity = saveNewMove();
		final IMove entityFromDb = moveService.getFullInfo(entity.getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getGame().getId());
		assertNotNull(entityFromDb.getPlayer().getId());
		assertNotNull(entityFromDb.getPiece());
		assertNotNull(entityFromDb.getMoveNotationFrom());
		assertNotNull(entityFromDb.getMoveNotationTo());
		assertNotNull(entityFromDb.getMoveTime());
		assertEquals(entity.getGame().getId(), entityFromDb.getGame().getId());
		assertEquals(entity.getPiece(), entityFromDb.getPiece());
		assertEquals(entity.getPlayer().getId(), entityFromDb.getPlayer().getId());
		assertEquals(entity.getMoveNotationFrom(), entityFromDb.getMoveNotationFrom());
		assertEquals(entity.getMoveNotationTo(), entityFromDb.getMoveNotationTo());
		assertEquals(entity.getMoveTime(), entityFromDb.getMoveTime());
	}

	@Test
	public void testGetAll() {
		final int intialCount = moveService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewMove();
		}

		final List<IMove> allEntities = moveService.find(new MoveFilter());

		for (final IMove entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getGame().getId());
			assertNotNull(entityFromDb.getPlayer().getId());
			assertNotNull(entityFromDb.getPiece());
			assertNotNull(entityFromDb.getMoveNotationFrom());
			assertNotNull(entityFromDb.getMoveNotationTo());
			assertNotNull(entityFromDb.getMoveTime());
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
