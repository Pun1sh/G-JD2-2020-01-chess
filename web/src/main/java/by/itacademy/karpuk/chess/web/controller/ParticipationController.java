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

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;
import by.itacademy.karpuk.chess.service.IParticipationService;
import by.itacademy.karpuk.chess.web.converter.ParticipationToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.ParticipationDTO;

@Controller
@RequestMapping(value = "/participation")
public class ParticipationController {
	@Autowired
	private IParticipationService participationService;
	@Autowired
	private ParticipationToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final ParticipationFilter filter = new ParticipationFilter();

		final List<IParticipation> entities = participationService.find(filter);
		List<ParticipationDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> participations = new HashMap<>();
		participations.put("gridItems", dtos);
		return new ModelAndView("participation.list", participations);
	}
}
