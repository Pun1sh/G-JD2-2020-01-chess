package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;

public class ClubServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IClub entity = saveNewClub();
		final IClub entityFromDb = clubService.get(entity.getId());
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getCreatedDate(), entity.getCreatedDate());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCreatedDate());
		assertEquals(entity.getNumberOfMembers(), entity.getNumberOfMembers());
	}

	@Test
	public void testGetAll() {
		final int intialCount = clubService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewClub();
		}

		final List<IClub> allEntities = clubService.getAll();

		for (final IClub entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getId());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IClub entity = saveNewClub();
		clubService.delete(entity.getId());
		assertNull(clubService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewClub();
		clubService.deleteAll();
		assertEquals(0, clubService.getAll().size());
	}
}
