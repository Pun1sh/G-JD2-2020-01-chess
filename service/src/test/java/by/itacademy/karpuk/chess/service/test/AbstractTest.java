package by.itacademy.karpuk.chess.service.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.service.IBoardService;
import by.itacademy.karpuk.chess.service.IClubService;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.service.IGameService;
import by.itacademy.karpuk.chess.service.IMessageService;
import by.itacademy.karpuk.chess.service.IModeService;
import by.itacademy.karpuk.chess.service.IMoveService;
import by.itacademy.karpuk.chess.service.IParticipationService;
import by.itacademy.karpuk.chess.service.IPieceService;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.service.ITournamentService;

@SpringJUnitConfig(locations = "classpath:service-context-test.xml")
public abstract class AbstractTest {
	@Autowired
	protected IPieceService pieceService;
	@Autowired
	protected IModeService modeService;
	@Autowired
	protected ICountryService countryService;
	@Autowired
	protected IClubService clubService;
	@Autowired
	protected IPlayerService playerService;
	@Autowired
	protected ITournamentService tournamentService;
	@Autowired
	protected IGameService gameService;
	@Autowired
	protected IMoveService moveService;
	@Autowired
	protected IBoardService boardService;
	@Autowired
	protected IMessageService messageService;
	@Autowired
	protected IParticipationService participationService;
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

	private static final Random RANDOM = new Random();

	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.user}")
	private String user;
	@Value("${jdbc.password}")
	private String password;

	@BeforeEach
	public final void recreateTestDB() throws SQLException, IOException {
		final long stampBefore = System.currentTimeMillis();

		final Connection conn = DriverManager.getConnection(url, user, password);

		try {
			final Statement stmt = conn.createStatement();
			try {
				stmt.execute("DROP SCHEMA IF EXISTS \"public\" CASCADE;");
				stmt.execute("CREATE SCHEMA \"public\";");
				stmt.execute(getScript());
			} finally {
				stmt.close();
			}
		} finally {
			conn.close();
		}

		LOGGER.info("Database recreated in {} seconds.",
				Double.valueOf((System.currentTimeMillis() - stampBefore) / 1000));
	}

	private String getScript() {

		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get("../docs/шахматы_postgres_create.sql"),
				StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
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
		entity.setTimeMinutes(getRandomObjectsCount());
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
		entity.setCreatedDate(new Date(System.currentTimeMillis()));
		entity.setNumberOfMembers(getRandomObjectsCount());
		entity.setCountry(saveNewCountry());
		clubService.save(entity);
		return entity;
	}

	// problem here
	protected IPlayer saveNewPlayer() {
		final IPlayer entity = playerService.createEntity();
		entity.setName("player-" + getRandomPrefix());
		entity.setSurname("player-" + getRandomPrefix());
		entity.setNickname(getRandomPrefix());
		entity.setCountry(saveNewCountry());
		entity.setRegistratedDate(new Date(System.currentTimeMillis()));
		entity.setClub(saveNewClub());
		entity.setGamesPlayed(getRandomObjectsCount());
		entity.setBirthDate(new Date(System.currentTimeMillis()));
		entity.setEmail(getRandomPrefix());
		entity.setPassword(getRandomPrefix());
		entity.setEloPoints(getRandomObjectsCount());
		entity.setRank(getRandomPrefix());
		playerService.save(entity);
		return entity;
	}

//problem here 
	protected ITournament saveNewTournament() {
		final ITournament entity = tournamentService.createEntity();
		entity.setName("tournament-" + getRandomPrefix());
		
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		
		entity.setStarted(instance.getTime());
		entity.setEnded(new Date());
		entity.setCountry(saveNewCountry());
		entity.setWinner(saveNewPlayer());
		tournamentService.save(entity);
		return entity;
	}

// problem here
	protected IGame saveNewGame() {
		final IGame entity = gameService.createEntity();
		entity.setWhitePlayer(saveNewPlayer());
		entity.setBlackPlayer(saveNewPlayer());
		entity.setWinner(saveNewPlayer());
		entity.setLoser(saveNewPlayer());
		entity.setTournament(saveNewTournament());
		entity.setStarted(new Date(System.currentTimeMillis()));
		entity.setEnded(new Date(System.currentTimeMillis()));
		entity.setMode(saveNewMode());
		gameService.save(entity);
		return entity;
	}

	protected IMove saveNewMove() {
		final IMove entity = moveService.createEntity();
		entity.setGame(saveNewGame());
		entity.setPlayer(saveNewPlayer());
		entity.setPiece(saveNewPiece());
		entity.setMoveNotationFrom("2");
		entity.setMoveNotationTo("2");
		entity.setMoveTime(getRandomObjectsCount());
		moveService.save(entity);
		return entity;
	}

	protected IBoard saveNewBoard() {
		final IBoard entity = boardService.createEntity();
		entity.setGame(saveNewGame());
		entity.setPiece(saveNewPiece());
		entity.setPositionLetter("A");
		entity.setPositionNumber(getRandomObjectsCount());
		boardService.save(entity);
		return entity;
	}

	protected IMessage saveNewMessage() {
		final IMessage entity = messageService.createEntity();
		entity.setWriter(saveNewPlayer());
		entity.setContent(getRandomPrefix());
		entity.setCreated(new Date(System.currentTimeMillis()));
		entity.setGame(saveNewGame());
		messageService.save(entity);
		return entity;
	}

	protected IParticipation saveNewParticipation() {
		final IParticipation entity = participationService.createEntity();
		entity.setPlayer(saveNewPlayer());
		entity.setTournament(saveNewTournament());
		entity.setTournamentPoints(getRandomObjectsCount());
		participationService.save(entity);
		return entity;
	}
}
