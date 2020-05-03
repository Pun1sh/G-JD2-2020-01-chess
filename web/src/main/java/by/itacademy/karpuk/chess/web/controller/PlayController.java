package by.itacademy.karpuk.chess.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import by.itacademy.karpuk.chess.service.IBoardService;
import by.itacademy.karpuk.chess.service.IGameService;
import by.itacademy.karpuk.chess.service.IPlayerService;

@Controller
@RequestMapping(value = "/play")
public class PlayController extends AbstractController {

	@Autowired
	IGameService gameService;
	@Autowired
	IPlayerService playerService;
	@Autowired
	IBoardService boardService;

	@RequestMapping(value = "/live_chess", method = RequestMethod.GET)
	public ModelAndView playLiveChess(
			@RequestParam(name = "white_player_id", required = true) final Integer whitePlayerId,
			@RequestParam(name = "black_player_id", required = true) final Integer blackPlayerId,
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("gameId", gameId);
		hashMap.put("whitePlayerId", whitePlayerId);
		hashMap.put("blackPlayerId", blackPlayerId);
		hashMap.put("newestBoardId", boardService.getNewestBoard(gameId)); // null
		return new ModelAndView("live_chess", hashMap);
	}

	@RequestMapping(value = "live_chess/lastId", method = RequestMethod.GET)
	public ResponseEntity<Integer> getNewestBoard(
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final IBoard newestBoard = boardService.getNewestBoard(gameId);
		return new ResponseEntity<Integer>(newestBoard == null ? null : newestBoard.getId(), HttpStatus.OK);
	}

	@RequestMapping(value = "live_chess/lastFen", method = RequestMethod.GET)
	public ResponseEntity<String> getNewestFen(@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final IBoard newestBoard = boardService.getNewestBoard(gameId);
		return new ResponseEntity<String>(newestBoard == null ? null : newestBoard.getFen(), HttpStatus.OK);
	}

	@RequestMapping(value = "/make_game", method = RequestMethod.GET)
	public String makeGame(@RequestParam(name = "white_player_id", required = true) final Integer whitePlayerId,
			@RequestParam(name = "black_player_id", required = true) final Integer blackPlayerId) {
		IGame newGame = gameService.createEntity();
		newGame.setWhitePlayer(playerService.getFullInfo(whitePlayerId));
		newGame.setBlackPlayer(playerService.getFullInfo(blackPlayerId));
		newGame.setMode(Mode.BLITZ);
		newGame.setStarted(new Date());
		gameService.save(newGame);
		return "redirect:/play/live_chess?white_player_id=" + whitePlayerId + "&black_player_id=" + blackPlayerId
				+ "&game_id=" + gameService.getFullInfo(newGame.getId()).getId();
	}

	@RequestMapping(value = "/board_editor", method = RequestMethod.GET)
	public String playBoardEditor() {
		return "board_editor";
	}

	@RequestMapping(value = "/random_computer", method = RequestMethod.GET)
	public String playRandomComputer() {
		return "random_computer";
	}

}
