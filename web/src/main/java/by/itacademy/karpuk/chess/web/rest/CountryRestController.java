package by.itacademy.karpuk.chess.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.web.converter.CountryFromDTOConverter;
import by.itacademy.karpuk.chess.web.converter.CountryToDTOConverter;
import by.itacademy.karpuk.chess.web.dto.CountryDTO;

@RestController
public class CountryRestController extends AbstractRestController {
	@Autowired
	ICountryService service;
	@Autowired
	CountryToDTOConverter toDtoConverter;
	@Autowired
	CountryFromDTOConverter fromDtoConverter;

	@GetMapping("/countries")
	public List<CountryDTO> get() {
		return service.getAll().stream().map(toDtoConverter).collect(Collectors.toList());
	}

	@PostMapping("/countries")
	public ResponseEntity<CountryDTO> post(@RequestBody CountryDTO newCountryDto) {
		ICountry newCountry = fromDtoConverter.apply(newCountryDto);
		service.save(newCountry);
		return new ResponseEntity<CountryDTO>(toDtoConverter.apply(newCountry), HttpStatus.CREATED);
	}

	@GetMapping("/countries/{id}")
	public ResponseEntity<CountryDTO> getById(@PathVariable Integer id) {
		ICountry country = service.get(id);
		if (country == null) {
			return new ResponseEntity<CountryDTO>(HttpStatus.NOT_FOUND);
		}
		CountryDTO dto = toDtoConverter.apply(country);
		return new ResponseEntity<CountryDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/countries/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/countries/{id}")
	public ResponseEntity<Void> put(@PathVariable Integer id, @RequestBody CountryDTO updatedCountryDto) {
		updatedCountryDto.setId(id);

		ICountry newCountry = fromDtoConverter.apply(updatedCountryDto);
		service.save(newCountry);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
