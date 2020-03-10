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

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.filter.ModeFilter;
import by.itacademy.karpuk.chess.service.IModeService;
import by.itacademy.karpuk.chess.web.converter.ModeToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.ModeDTO;

@Controller
@RequestMapping(value = "/mode")
public class ModeController {
	@Autowired
	private IModeService modeService;
	@Autowired
	private ModeToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final ModeFilter filter = new ModeFilter();

		final List<IMode> entities = modeService.find(filter);
		List<ModeDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> modes = new HashMap<>();
		modes.put("gridItems", dtos);
		return new ModelAndView("mode.list", modes);
	}

}
