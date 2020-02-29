package by.itacademy.karpuk.chess.service.test;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

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
import by.itacademy.karpuk.chess.service.impl.BoardServiceImpl;
import by.itacademy.karpuk.chess.service.impl.ClubServiceImpl;
import by.itacademy.karpuk.chess.service.impl.CountryServiceImpl;
import by.itacademy.karpuk.chess.service.impl.GameServiceImpl;
import by.itacademy.karpuk.chess.service.impl.MessageServiceImpl;
import by.itacademy.karpuk.chess.service.impl.ModeServiceImpl;
import by.itacademy.karpuk.chess.service.impl.MoveServiceImpl;
import by.itacademy.karpuk.chess.service.impl.ParticipationServiceImpl;
import by.itacademy.karpuk.chess.service.impl.PieceServiceImpl;
import by.itacademy.karpuk.chess.service.impl.PlayerServiceImpl;
import by.itacademy.karpuk.chess.service.impl.TournamentServiceImpl;

public class AbstractTest {
	protected IPieceService pieceService = new PieceServiceImpl();
	protected IModeService modeService = new ModeServiceImpl();
	protected ICountryService countryService = new CountryServiceImpl();
	protected IClubService clubService = new ClubServiceImpl();
	protected IPlayerService playerService = new PlayerServiceImpl();
	protected ITournamentService tournamentService = new TournamentServiceImpl();
	protected IGameService gameService = new GameServiceImpl();
	protected IMoveService moveService = new MoveServiceImpl();
	protected IBoardService boardService = new BoardServiceImpl();
	protected IMessageService messageService = new MessageServiceImpl();
	protected IParticipationService participationService = new ParticipationServiceImpl();

	private static final Random RANDOM = new Random();

	@BeforeEach
	public void setUpMethod() {
		boardService.deleteAll();
		moveService.deleteAll();
		pieceService.deleteAll();
		messageService.deleteAll();
		gameService.deleteAll();
		modeService.deleteAll();
		participationService.deleteAll();
		tournamentService.deleteAll();
		playerService.deleteAll();
		clubService.deleteAll();
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

	// problem
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

//problem
	protected ITournament saveNewTournament() {
		final ITournament entity = tournamentService.createEntity();
		entity.setName("tournament-" + getRandomPrefix());
		entity.setStarted(new Date(System.currentTimeMillis()));
		entity.setEnded(new Date(System.currentTimeMillis()));
		entity.setCountry(saveNewCountry());
		entity.setWinner(saveNewPlayer());
		tournamentService.save(entity);
		return entity;
	}

// problem
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
