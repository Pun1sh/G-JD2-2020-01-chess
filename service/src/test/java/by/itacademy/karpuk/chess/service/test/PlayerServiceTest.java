package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;

public class PlayerServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IPlayer entity = saveNewPlayer();

		final IPlayer entityFromDb = playerService.get(entity.getId());

		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getCountry().getId(), entityFromDb.getCountry().getId());
		assertEquals(entity.getClub().getId(), entityFromDb.getClub().getId());
		assertNotNull(entityFromDb.getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = playerService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewPlayer();
		}

		final List<IPlayer> allEntities = playerService.getAll();

		for (final IPlayer entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getId());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IPlayer entity = saveNewPlayer();
		playerService.delete(entity.getId());
		assertNull(playerService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewPlayer();
		playerService.deleteAll();
		assertEquals(0, playerService.getAll().size());
	}
}
