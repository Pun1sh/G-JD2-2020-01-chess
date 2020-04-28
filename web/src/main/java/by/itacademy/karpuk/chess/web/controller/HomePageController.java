package by.itacademy.karpuk.chess.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.converter.PlayerToDTOConverter;

@Controller
@RequestMapping(value = "/")
public class HomePageController {
	@Autowired
	private IPlayerService playerService;
	@Autowired
	private PlayerToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IPlayer player = playerService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(player));
		return new ModelAndView("home", hashMap);

	}

}