package by.itacademy.karpuk.chess.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.converter.PlayerFromDTOConverter;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;
import by.itacademy.karpuk.chess.web.security.PasswordUtils;

@Controller
@RequestMapping(value = "/sign_up")
public class SignUpController extends AbstractController {

	@Autowired
	IPlayerService playerService;
	@Autowired
	private PlayerFromDTOConverter fromDtoConverter;

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final PlayerDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "home";
		} else {
			String salt = PasswordUtils.getSalt(30);
			String securePassword = PasswordUtils.generateSecurePassword(formModel.getPassword(), salt);
			formModel.setPassword(securePassword);
			formModel.setSalt(salt);
			formModel.setCountryId(null);
			formModel.setRegistrated(new Date());
			formModel.setGamesPlayed(0);
			formModel.setEloPoints(800);
			formModel.setRank("New");
			formModel.setClubId(null);
			final IPlayer entity = fromDtoConverter.apply(formModel);
			playerService.save(entity);
			return "redirect:/player";
		}
	}

}
