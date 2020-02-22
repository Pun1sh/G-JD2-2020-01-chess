package by.itacademy.karpuk.chess.service.test;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.service.IClubService;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.service.IModeService;
import by.itacademy.karpuk.chess.service.IPieceService;
import by.itacademy.karpuk.chess.service.impl.ClubServiceImpl;
import by.itacademy.karpuk.chess.service.impl.CountryServiceImpl;
import by.itacademy.karpuk.chess.service.impl.ModeServiceImpl;
import by.itacademy.karpuk.chess.service.impl.PieceServiceImpl;

public class AbstractTest {
	protected IPieceService pieceService = new PieceServiceImpl();
	protected IModeService modeService = new ModeServiceImpl();
	protected ICountryService countryService = new CountryServiceImpl();
	protected IClubService clubService = new ClubServiceImpl();

	private static final Random RANDOM = new Random();

	@BeforeEach
	public void setUpMethod() {
		pieceService.deleteAll();
		modeService.deleteAll();
		countryService.deleteAll();
	}

	protected String getRandomPrefix() {
		return RANDOM.nextInt(99999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(9) + 1;
	}

	public Random getRANDOM() {
		return RANDOM;
	}

	protected IPiece saveNewPiece() {
		final IPiece entity = pieceService.createEntity();
		entity.setName("piece-" + getRandomPrefix());
		pieceService.save(entity);
		return entity;
	}

	protected IMode saveNewMode() {
		final IMode entity = modeService.createEntity();
		entity.setName("mode-" + getRandomPrefix());
		modeService.save(entity);
		return entity;
	}

	protected ICountry saveNewCountry() {
		final ICountry entity = countryService.createEntity();
		entity.setName("country-" + getRandomPrefix());
		countryService.save(entity);
		return entity;
	}

	protected IClub saveNewClub() {
		final IClub entity = clubService.createEntity();
		entity.setName("club-" + getRandomPrefix());
		clubService.save(entity);
		return entity;
	}
}
