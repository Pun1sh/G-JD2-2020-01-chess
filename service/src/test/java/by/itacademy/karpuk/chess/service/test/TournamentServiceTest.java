package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;

public class TournamentServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final ITournament entity = saveNewTournament();
		final ITournament entityFromDb = tournamentService.get(entity.getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getName());
		assertNotNull(entityFromDb.getStarted());
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getStarted(), entityFromDb.getStarted());
		assertEquals(entity.getCountry().getId(), entityFromDb.getCountry().getId());
		assertEquals(entity.getWinner().getId(), entityFromDb.getWinner().getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = tournamentService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewTournament();
		}

		final List<ITournament> allEntities = tournamentService.getAll();

		for (final ITournament entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getStarted());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ITournament entity = saveNewTournament();
		tournamentService.delete(entity.getId());
		assertNull(tournamentService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewTournament();
		tournamentService.deleteAll();
		assertEquals(0, tournamentService.getAll().size());
	}
}
