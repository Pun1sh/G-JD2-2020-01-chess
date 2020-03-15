package by.itacademy.karpuk.chess.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;
import by.itacademy.karpuk.chess.service.IGameService;
import by.itacademy.karpuk.chess.web.converter.GameToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.GameDTO;

@Controller
@RequestMapping(value = "/game")
public class GameController {
	@Autowired
	private IGameService gameService;
	@Autowired
	private GameToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final GameFilter filter = new GameFilter();

		final List<IGame> entities = gameService.find(filter);
		List<GameDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> games = new HashMap<>();
		games.put("gridItems", dtos);
		return new ModelAndView("game.list", games);
	}
}
