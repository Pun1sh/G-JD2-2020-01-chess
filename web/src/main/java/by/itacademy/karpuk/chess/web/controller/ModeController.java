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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.filter.ModeFilter;
import by.itacademy.karpuk.chess.service.IModeService;
import by.itacademy.karpuk.chess.web.converter.ModeFromDTOConverter;
import by.itacademy.karpuk.chess.web.converter.ModeToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.ModeDTO;
import by.itacademy.karpuk.chess.web.dto.grid.GridStateDTO;

@Controller
@RequestMapping(value = "/mode")
public class ModeController extends AbstractController {
	@Autowired
	private IModeService modeService;
	@Autowired
	private ModeToDTOConverter toDtoConverter;
	@Autowired
	private ModeFromDTOConverter fromDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final ModeFilter filter = new ModeFilter();
		prepareFilter(gridState, filter);

		final List<IMode> entities = modeService.find(filter);
		List<ModeDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(modeService.getCount(filter));

		final Map<String, Object> modes = new HashMap<>();
		modes.put("gridItems", dtos);
		return new ModelAndView("mode.list", modes);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IMode newEntity = modeService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));
		return new ModelAndView("mode.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final ModeDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "mode.edit";
		} else {
			final IMode entity = fromDtoConverter.apply(formModel);
			modeService.save(entity);
			return "redirect:/mode";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) Integer id) {
		modeService.delete(id);
		return "redirect:/mode";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IMode dbModel = modeService.get(id);
		final ModeDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("mode.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final ModeDTO dto = toDtoConverter.apply(modeService.get(id));
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		return new ModelAndView("mode.edit", hashMap);
	}

}
