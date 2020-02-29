package by.itacademy.karpuk.chess.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;

public class MessageServiceTest extends AbstractTest {
	@Test
	public void createTest() {
		final IMessage entity = saveNewMessage();

		final IMessage entityFromDb = messageService.get(entity.getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getWriter().getId());
		assertNotNull(entityFromDb.getGame().getId());
		assertNotNull(entityFromDb.getContent());
		assertNotNull(entityFromDb.getCreated());
		assertEquals(entity.getGame().getId(), entityFromDb.getGame().getId());
		assertEquals(entity.getWriter().getId(), entityFromDb.getWriter().getId());
		assertEquals(entity.getContent(), entityFromDb.getContent());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());

	}

	@Test
	public void testGetAll() {
		final int intialCount = messageService.getAll().size();
		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewMessage();
		}

		final List<IMessage> allEntities = messageService.getAll();

		for (final IMessage entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getWriter().getId());
			assertNotNull(entityFromDb.getGame().getId());
			assertNotNull(entityFromDb.getContent());
			assertNotNull(entityFromDb.getCreated());
		}

		assertEquals(randomObjectsCount + intialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IMessage entity = saveNewMessage();
		messageService.delete(entity.getId());
		assertNull(messageService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		saveNewMessage();
		messageService.deleteAll();
		assertEquals(0, messageService.getAll().size());
	}
}
