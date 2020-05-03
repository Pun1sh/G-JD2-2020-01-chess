package by.itacademy.karpuk.chess.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Board;
import by.itacademy.karpuk.chess.service.IBoardService;
import by.itacademy.karpuk.chess.service.IGameService;

@Controller
@RequestMapping(value = "play/live_chess/board_insert")

public class BoardInsertController extends AbstractController {

	@Autowired
	private IBoardService boardService;
	@Autowired
	private IGameService gameService;

	@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public ResponseEntity insertData(@RequestBody Board board,
			@RequestParam(name = "game_id", required = true) final Integer gameId) {
		IBoard boardPosition = boardService.createEntity();
		IGame game = gameService.getFullInfo(gameId);
		boardPosition.setFen(board.getFen());
		boardPosition.setGame(game);
		boardService.save(boardPosition);
		return new ResponseEntity("{}", HttpStatus.OK);

	}

}
