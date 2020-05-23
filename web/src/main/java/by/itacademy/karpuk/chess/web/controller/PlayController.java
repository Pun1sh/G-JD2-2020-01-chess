package by.itacademy.karpuk.chess.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.enums.Mode;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.service.IBoardService;
import by.itacademy.karpuk.chess.service.IGameService;
import by.itacademy.karpuk.chess.service.IMoveService;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.dto.GameDTO;
import by.itacademy.karpuk.chess.web.dto.MoveDTO;
import by.itacademy.karpuk.chess.web.security.AuthHelper;
import by.itacademy.karpuk.chess.web.utils.UsersHolderWithExpiration;

@Controller
@RequestMapping(value = "/play")
public class PlayController extends AbstractController {

	@Autowired
	IGameService gameService;
	@Autowired
	IPlayerService playerService;
	@Autowired
	IBoardService boardService;
	@Autowired
	IMoveService moveService;

	@RequestMapping(value = "/live_chess", method = RequestMethod.GET)
	public ModelAndView playLiveChess(
			@RequestParam(name = "white_player_id", required = true) final Integer whitePlayerId,
			@RequestParam(name = "black_player_id", required = true) final Integer blackPlayerId,
			@RequestParam(name = "game_id", required = true) final Integer gameId,
			@RequestParam(name = "mode", required = true) final String mode) {
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("gameId", gameId);
		hashMap.put("whitePlayerId", whitePlayerId);
		hashMap.put("blackPlayerId", blackPlayerId);
		if (boardService.getNewestBoard(gameId) != null) {
			hashMap.put("newestBoardId", boardService.getNewestBoard(gameId).getId());
		} else {
			hashMap.put("newestBoardId", boardService.getNewestBoard(gameId)); // null
		}
		hashMap.put("userId", AuthHelper.getLoggedUserId());
		hashMap.put("mode", gameService.getFullInfo(gameId).getMode().getTime());
		if (mode.equals("NO_TIME")) {
			return new ModelAndView("live_chess_no_time", hashMap);
		}
		return new ModelAndView("live_chess", hashMap);
	}

	@RequestMapping(value = "live_chess/last_id", method = RequestMethod.GET)
	public ResponseEntity<Integer> getNewestBoard(
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final IBoard newestBoard = boardService.getNewestBoard(gameId);
		return new ResponseEntity<Integer>(newestBoard == null ? null : newestBoard.getId(), HttpStatus.OK);
	}

	@RequestMapping(value = "live_chess/last_move", method = RequestMethod.GET)
	public ResponseEntity<MoveDTO> getNewestMove(
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final IMove newestMove = moveService.getNewestMove(gameId);
		MoveDTO dto = new MoveDTO();
		if (!(newestMove == null)) {
			dto.setMoveNotationFrom(newestMove.getMoveNotationFrom());
			dto.setMoveNotationTo(newestMove.getMoveNotationTo());
		}
		return new ResponseEntity<MoveDTO>(dto == null ? null : dto, HttpStatus.OK);
	}

	@RequestMapping(value = "live_chess/last_fen", method = RequestMethod.GET)
	public ResponseEntity<String> getFenIfClose(@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final IBoard newestBoard = boardService.getNewestBoard(gameId);
		String str = null;
		if (newestBoard != null) {
			str = newestBoard.getFen();
		}
		return new ResponseEntity<String>(str == null ? null : str, HttpStatus.OK);
	}

	@RequestMapping(value = "/make_game", method = RequestMethod.GET)
	public String makeGame(@RequestParam(name = "white_player_id", required = true) final Integer whitePlayerId,
			@RequestParam(name = "black_player_id", required = true) final Integer blackPlayerId,
			@RequestParam(name = "mode", required = true) final Integer mode) {
		IGame newGame = gameService.createEntity();
		newGame.setWhitePlayer(playerService.getFullInfo(whitePlayerId));
		newGame.setBlackPlayer(playerService.getFullInfo(blackPlayerId));
		if (mode == 1) {
			newGame.setMode(Mode.BLITZ);
		} else if (mode == 2) {
			newGame.setMode(Mode.TEN);
		} else if (mode == 3) {
			newGame.setMode(Mode.THIRTY);
		} else if (mode == 4) {
			newGame.setMode(Mode.SIXTY);
		} else if(mode==5) {
			newGame.setMode(Mode.NO_TIME);
		}
		else {
			throw new RuntimeException("No mode in request");
		}
		newGame.setStarted(new Date());
		gameService.save(newGame);
		return "redirect:/play/live_chess?white_player_id=" + whitePlayerId + "&black_player_id=" + blackPlayerId
				+ "&game_id=" + gameService.getFullInfo(newGame.getId()).getId() + "&mode="
				+ gameService.getFullInfo(newGame.getId()).getMode();
	}

	@RequestMapping(value = "/game_over_with_result", method = RequestMethod.POST)
	public void endGameWithResult(final HttpServletRequest req, final HttpServletResponse res,
			@RequestParam(name = "game_id", required = true) final Integer gameId,
			@RequestParam(name = "winner_id", required = true) final Integer winnerId,
			@RequestParam(name = "loser_id", required = true) final Integer loserId) {
		IGame game = gameService.getFullInfo(gameId);
		game.setWinner(playerService.get(winnerId));
		game.setLoser(playerService.get(loserId));
		game.setEnded(new Date());
		IPlayer winner = playerService.getFullInfo(winnerId);
		IPlayer loser = playerService.getFullInfo(loserId);
		winner.setGamesPlayed(winner.getGamesPlayed() + 1);
		loser.setGamesPlayed(loser.getGamesPlayed() + 1);
		winner.setEloPoints(winner.getEloPoints() + 10);
		loser.setEloPoints(loser.getEloPoints() - 10);
		playerService.save(loser);
		playerService.save(winner);
		gameService.save(game);
	}

	@RequestMapping(value = "/game_over_without_result", method = RequestMethod.POST)
	public void endGameWithoutResult(final HttpServletRequest req, final HttpServletResponse res,
			@RequestParam(name = "game_id", required = true) final Integer gameId,
			@RequestParam(name = "white_player_id", required = true) final Integer whitePlayerId,
			@RequestParam(name = "black_player_id", required = true) final Integer blackPlayerId) {
		IGame game = gameService.getFullInfo(gameId);
		game.setEnded(new Date());
		IPlayer whitePlayer = playerService.getFullInfo(whitePlayerId);
		IPlayer blackPlayer = playerService.getFullInfo(blackPlayerId);
		whitePlayer.setGamesPlayed(whitePlayer.getGamesPlayed() + 1);
		blackPlayer.setGamesPlayed(blackPlayer.getGamesPlayed() + 1);
		whitePlayer.setEloPoints(whitePlayer.getEloPoints() + 2);
		blackPlayer.setEloPoints(blackPlayer.getEloPoints() + 2);
		gameService.save(game);
		playerService.save(whitePlayer);
		playerService.save(blackPlayer);

	}

	@RequestMapping(value = "/user_here", method = RequestMethod.GET)
	public ResponseEntity<Date> endGameUserLeave(final HttpServletRequest req, final HttpServletResponse res,
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		IGame currentGame = gameService.getFullInfo(gameId);
		Date ended = currentGame.getEnded();
		return new ResponseEntity<Date>(ended == null ? null : ended, HttpStatus.OK);
	}

	@RequestMapping(value = "/board_editor", method = RequestMethod.GET)
	public String playBoardEditor() {
		return "board_editor";
	}

	@RequestMapping(value = "/random_computer", method = RequestMethod.GET)
	public String playRandomComputer() {
		return "random_computer";
	}

	@RequestMapping(value = "/queue", method = RequestMethod.GET)
	public ModelAndView getInLine(final HttpServletRequest req) {
		final Map<String, Object> map = new HashMap<>();
		map.put("loggedUserId", AuthHelper.getLoggedUserId());
		map.put("gameId", null);
		return new ModelAndView("waiting", map);
	}

	@RequestMapping(value = "/queue/stay_in_queue", method = RequestMethod.GET)
	public void stayInQueue(final HttpServletRequest req, final HttpServletResponse res,
			@RequestParam(name = "player_id", required = true) final Integer playerId) {
		UsersHolderWithExpiration usersHolderWithExpiration = UsersHolderWithExpiration.INSTANCE;
		usersHolderWithExpiration.put(playerId);

	}

	@RequestMapping(value = "/queue/check_id", method = RequestMethod.GET)
	public ResponseEntity<Integer> checkId(final HttpServletRequest req,
			@RequestParam(name = "player_id", required = true) final Integer playerId) {
		Integer gameId = null;
		if (gameService.checkForGame(playerId) != null) {
			gameId = gameService.checkForGame(playerId).getId();
		}
		return new ResponseEntity<Integer>(gameId == null ? null : gameId, HttpStatus.OK);
	}

	@RequestMapping(value = "/queue/get_game", method = RequestMethod.GET)
	public ResponseEntity<GameDTO> getGame(final HttpServletRequest req,
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		IGame game = gameService.getFullInfo(gameId);
		GameDTO dto = new GameDTO();
		dto.setId(game.getId());
		dto.setWhitePlayerId(game.getWhitePlayer().getId());
		dto.setBlackPlayerId(game.getBlackPlayer().getId());
		dto.setMode(game.getMode());
		return new ResponseEntity<GameDTO>(dto == null ? null : dto, HttpStatus.OK);
		
	}
	
}
