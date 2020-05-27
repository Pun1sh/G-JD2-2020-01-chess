package by.itacademy.karpuk.chess.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.service.IGameService;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.converter.GameToDTOConverter;
import by.itacademy.karpuk.chess.web.converter.PlayerToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.GameDTO;
import by.itacademy.karpuk.chess.web.jndi.SMTPCredentials;
import by.itacademy.karpuk.chess.web.security.AuthHelper;

@Controller
@RequestMapping(value = "/")
public class HomePageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);
	@Autowired
	private SMTPCredentials smtpCredentials;
	@Autowired
	private IPlayerService playerService;
	@Autowired
	private PlayerToDTOConverter toDtoConverter;
	@Autowired
	private IGameService gameService;
	@Autowired
	private GameToDTOConverter gameToDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IPlayer player = playerService.createEntity();
		GameDTO game = new GameDTO();
		if (gameService.checkForGame(AuthHelper.getLoggedUserId()) != null) {
			game = gameToDtoConverter.apply(gameService.checkForGame(AuthHelper.getLoggedUserId()));
		}
		hashMap.put("formModel", toDtoConverter.apply(player));
		hashMap.put("game", game);
		if (AuthHelper.getLoggedUserId()!=null) {
			hashMap.put("loggedUserId", AuthHelper.getLoggedUserId());
			hashMap.put("loggedUserNickname", playerService.get(AuthHelper.getLoggedUserId()).getNickname());
		}
		return new ModelAndView("home", hashMap);

	}

	@PostConstruct
	private void init() {
		Validate.notEmpty(smtpCredentials.getEmail());
		LOGGER.info("email from custom JNDI resource:{}", smtpCredentials.getEmail());
	}

}