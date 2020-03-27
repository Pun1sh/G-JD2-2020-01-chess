package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;

public class PlayerServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IPlayer entity = saveNewPlayer();
		final IPlayer entityFromDb = playerService.getFullInfo(entity.getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getNickname());
		assertNotNull(entityFromDb.getCountry().getId());
		assertNotNull(entityFromDb.getRegistrated());
		assertNotNull(entityFromDb.getGamesPlayed());
		assertNotNull(entityFromDb.getBirthDate());
		assertNotNull(entityFromDb.getEmail());
		assertNotNull(entityFromDb.getPassword());
		assertNotNull(entityFromDb.getEloPoints());
		assertNotNull(entityFromDb.getRank());
		assertEquals(entity.getNickname(), entityFromDb.getNickname());
		assertEquals(entity.getCountry().getId(), entityFromDb.getCountry().getId());
		assertEquals(entity.getRegistrated(), entityFromDb.getRegistrated());
		assertEquals(entity.getClub().getId(), entityFromDb.getClub().getId());
		assertEquals(entity.getGamesPlayed(), entityFromDb.getGamesPlayed());
		assertEquals(entity.getBirthDate(), entityFromDb.getBirthDate());
		assertEquals(entity.getEmail(), entityFromDb.getEmail());
		assertEquals(entity.getPassword(), entityFromDb.getPassword());
		assertEquals(entity.getEloPoints(), entityFromDb.getEloPoints());
		assertEquals(entity.getRank(), entityFromDb.getRank());
	}

	@Test
	public void testGetAll() {
		final int intialCount = playerService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewPlayer();
		}

		final List<IPlayer> allEntities = playerService.find(new PlayerFilter());

		for (final IPlayer entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getNickname());
			assertNotNull(entityFromDb.getCountry().getId());
			assertNotNull(entityFromDb.getRegistrated());
			assertNotNull(entityFromDb.getClub().getId());
			assertNotNull(entityFromDb.getGamesPlayed());
			assertNotNull(entityFromDb.getBirthDate());
			assertNotNull(entityFromDb.getEmail());
			assertNotNull(entityFromDb.getPassword());
			assertNotNull(entityFromDb.getEloPoints());
			assertNotNull(entityFromDb.getRank());
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
