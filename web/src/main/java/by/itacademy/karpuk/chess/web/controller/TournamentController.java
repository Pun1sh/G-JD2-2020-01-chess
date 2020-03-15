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

import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;
import by.itacademy.karpuk.chess.service.ITournamentService;
import by.itacademy.karpuk.chess.web.converter.TournamentToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.TournamentDTO;

@Controller
@RequestMapping(value = "/tournament")
public class TournamentController {
	@Autowired
	private ITournamentService tournamentService;
	@Autowired
	private TournamentToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final TournamentFilter filter = new TournamentFilter();

		final List<ITournament> entities = tournamentService.find(filter);
		List<TournamentDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> tournaments = new HashMap<>();
		tournaments.put("gridItems", dtos);
		return new ModelAndView("tournament.list", tournaments);
	}
}
