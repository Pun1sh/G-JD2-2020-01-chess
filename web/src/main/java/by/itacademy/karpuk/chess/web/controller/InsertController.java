package by.itacademy.karpuk.chess.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.service.IBoardService;
import by.itacademy.karpuk.chess.service.IGameService;

@Controller
@RequestMapping(value = "/insert")

public class InsertController extends AbstractController {

	@Autowired
	private IBoardService boardService;
	@Autowired
	private IGameService gameService;

	@RequestMapping(method = RequestMethod.POST)
	public void insertData(final HttpServletRequest req) {
		IBoard entity = boardService.createEntity();
		entity.setFen(req.getParameter("data"));
		entity.setGame(gameService.createEntity());
		boardService.save(entity);
	}

}
