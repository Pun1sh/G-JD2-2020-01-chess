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

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.filter.CountryFilter;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.web.converter.CountryToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.CountryDTO;

@Controller
@RequestMapping(value = "/country")
public class CountryController {
	@Autowired
	private ICountryService countryService;
	@Autowired
	private CountryToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final CountryFilter filter = new CountryFilter();

		final List<ICountry> entities = countryService.find(filter);
		List<CountryDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> countries = new HashMap<>();
		countries.put("gridItems", dtos);
		return new ModelAndView("country.list", countries);
	}

}
