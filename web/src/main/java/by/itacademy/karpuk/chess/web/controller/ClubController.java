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

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;
import by.itacademy.karpuk.chess.service.IClubService;
import by.itacademy.karpuk.chess.web.converter.ClubToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.ClubDTO;

@Controller
@RequestMapping(value = "/club")
public class ClubController {
	@Autowired
	private IClubService clubService;
	@Autowired
	private ClubToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final ClubFilter filter = new ClubFilter();

		final List<IClub> entities = clubService.find(filter);
		List<ClubDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> clubs = new HashMap<>();
		clubs.put("gridItems", dtos);
		return new ModelAndView("club.list", clubs);
	}
}
