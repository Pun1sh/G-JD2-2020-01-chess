package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;

public class ParticipationServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final IParticipation entity = saveNewParticipation();

		final IParticipation entityFromDb = participationService.get(entity.getId());
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getPlayer().getId(), entityFromDb.getPlayer().getId());
		assertEquals(entity.getTournament().getId(), entityFromDb.getTournament().getId());
	}

	@Test
	public void testGetAll() {
		final int intialCount = participationService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewParticipation();
		}

		final List<IParticipation> allEntities = participationService.getAll();

		for (final IParticipation entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IParticipation entity = saveNewParticipation();
		participationService.delete(entity.getId());
		assertNull(participationService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewParticipation();
		participationService.deleteAll();
		assertEquals(0, participationService.getAll().size());
	}
}
