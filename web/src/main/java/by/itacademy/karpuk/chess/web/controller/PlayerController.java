package by.itacademy.karpuk.chess.web.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.converter.PlayerFromDTOConverter;
import by.itacademy.karpuk.chess.web.converter.PlayerToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;
import by.itacademy.karpuk.chess.web.dto.grid.GridStateDTO;
import by.itacademy.karpuk.chess.web.security.AuthHelper;
import by.itacademy.karpuk.chess.web.utils.UsersHolderWithExpiration;

@Controller
@RequestMapping(value = "/player")
public class PlayerController extends AbstractController {
	@Autowired
	private IPlayerService playerService;
	@Autowired
	private ICountryService countryService;
	@Autowired
	private PlayerToDTOConverter toDtoConverter;
	@Autowired
	private PlayerFromDTOConverter fromDtoConverter;

	@RequestMapping(value = "/waiting_players", method = RequestMethod.GET)
	public ModelAndView getWaitingPlayers(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final PlayerFilter filter = new PlayerFilter();
		prepareFilter(gridState, filter);

		UsersHolderWithExpiration usersHolderWithExpiration = UsersHolderWithExpiration.INSTANCE;

		List<IPlayer> entities = new ArrayList<>();
		for (int i = 0; i < usersHolderWithExpiration.getAll().size(); i++) {
			entities.add(playerService.getFullInfo(usersHolderWithExpiration.getAll().get(i)));
		}

		List<PlayerDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(playerService.getCount(filter));

		final Map<String, Object> players = new HashMap<>();
		players.put("gridItems", dtos);
		players.put("loggedUserId", AuthHelper.getLoggedUserId());
		players.put("size", usersHolderWithExpiration.getAll().size());
		return new ModelAndView("waiting.list", players);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {
		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final PlayerFilter filter = new PlayerFilter();
		prepareFilter(gridState, filter);

		final List<IPlayer> entities = playerService.find(filter);

		List<PlayerDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(playerService.getCount(filter));

		final Map<String, Object> players = new HashMap<>();
		players.put("gridItems", dtos);
		players.put("loggedUserId", AuthHelper.getLoggedUserId());
		return new ModelAndView("player.list", players);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IPlayer player = playerService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(player));
		loadCommonFormModels(hashMap);
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

	private void loadCommonFormModels(final Map<String, Object> hashMap) {

		final List<ICountry> countries = countryService.getAll();

		final Map<Integer, String> countriesMap = countries.stream()
				.collect(Collectors.toMap(ICountry::getId, ICountry::getName));
		hashMap.put("countriesChoices", countriesMap);
	}
}
