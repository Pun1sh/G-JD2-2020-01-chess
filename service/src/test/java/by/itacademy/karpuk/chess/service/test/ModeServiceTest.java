package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;

public class ModeServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final IMode entity = saveNewMode();
		final IMode entityFromDb = modeService.get(entity.getId());
		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getName());
		assertNotNull(entityFromDb.getTimeMinutes());
		assertEquals(entity.getName(), entityFromDb.getName());
		assertEquals(entity.getTimeMinutes(), entityFromDb.getTimeMinutes());

	}

	@Test
	public void testGetAll() {
		final int intialCount = modeService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewMode();
		}

		final List<IMode> allEntities = modeService.getAll();

		for (final IMode entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getTimeMinutes());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IMode entity = saveNewMode();
		modeService.delete(entity.getId());
		assertNull(modeService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewMode();
		modeService.deleteAll();
		assertEquals(0, modeService.getAll().size());
	}
}
