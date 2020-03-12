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

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.converter.PlayerToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;

@Controller
@RequestMapping(value = "/player")
public class PlayerController {
	@Autowired
	private IPlayerService playerService;
	@Autowired
	private PlayerToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final PlayerFilter filter = new PlayerFilter();

		final List<IPlayer> entities = playerService.find(filter);
		List<PlayerDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> players = new HashMap<>();
		players.put("gridItems", dtos);
		return new ModelAndView("player.list", players);
	}
}
