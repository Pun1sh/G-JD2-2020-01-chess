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

import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Move;
import by.itacademy.karpuk.chess.service.IGameService;
import by.itacademy.karpuk.chess.service.IMoveService;
import by.itacademy.karpuk.chess.service.IPlayerService;

@Controller
@RequestMapping(value = "play/live_chess/move_insert")
public class MoveInsertController extends AbstractController {
	@Autowired
	private IMoveService moveService;
	@Autowired
	private IGameService gameService;
	@Autowired
	private IPlayerService playerService;

	@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public ResponseEntity insertData(@RequestBody Move move,
			@RequestParam(name = "game_id", required = true) final Integer gameId,
			@RequestParam(name = "player_id", required = true) final Integer playerId) {
		IMove newMove = moveService.createEntity();
		newMove.setGame(gameService.getFullInfo(gameId));
		newMove.setPiece(move.getPiece());
		newMove.setMoveNotationFrom(move.getMoveNotationFrom());
		newMove.setMoveNotationTo(move.getMoveNotationTo());
		newMove.setMoveTime(10);
		newMove.setPlayer(playerService.getFullInfo(playerId));
		moveService.save(newMove);
		return new ResponseEntity("{}", HttpStatus.OK);

	}

}
