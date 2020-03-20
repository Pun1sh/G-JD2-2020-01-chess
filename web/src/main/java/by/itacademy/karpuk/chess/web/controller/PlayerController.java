package by.itacademy.karpuk.chess.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.converter.PlayerFromDTOConverter;
import by.itacademy.karpuk.chess.web.converter.PlayerToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;

@Controller
@RequestMapping(value = "/player")
public class PlayerController extends AbstractController {
	@Autowired
	private IPlayerService playerService;
	@Autowired
	private PlayerToDTOConverter toDtoConverter;
	@Autowired
	private PlayerFromDTOConverter fromDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final PlayerFilter filter = new PlayerFilter();

		final List<IPlayer> entities = playerService.find(filter);
		List<PlayerDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> players = new HashMap<>();
		players.put("gridItems", dtos);
		return new ModelAndView("player.list", players);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IPlayer newEntity = playerService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));
		return new ModelAndView("player.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final PlayerDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "player.edit";
		} else {
			final IPlayer entity = fromDtoConverter.apply(formModel);
			playerService.save(entity);
			return "redirect:/player";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) Integer id) {
		playerService.delete(id);
		return "redirect:/player";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IPlayer dbModel = playerService.get(id);
		final PlayerDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("player.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final PlayerDTO dto = toDtoConverter.apply(playerService.get(id));
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		return new ModelAndView("player.edit", hashMap);
	}
}
