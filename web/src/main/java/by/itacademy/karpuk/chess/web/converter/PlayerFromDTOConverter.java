package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.service.IClubService;
import by.itacademy.karpuk.chess.service.ICountryService;
import by.itacademy.karpuk.chess.service.IPlayerService;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;

@Component
public class PlayerFromDTOConverter implements Function<PlayerDTO, IPlayer> {
	@Autowired
	private IPlayerService playerService;
	@Autowired
	private ICountryService countryService;
	@Autowired
	private IClubService clubService;

	@Override
	public IPlayer apply(PlayerDTO t) {
		ICountry country = countryService.createEntity();
		country.setId(t.getCountryId());
		IClub club = clubService.createEntity();
		club.setId(t.getClubId());
		IPlayer entity = playerService.createEntity();
		entity.setId(t.getId());
		entity.setName(t.getName());
		entity.setSurname(t.getSurname());
		entity.setNickname(t.getNickname());
		entity.setCountry(country);
		entity.setRegistrated(t.getRegistratedDate());
		entity.setClub(club);
		entity.setGamesPlayed(t.getGamesPlayed());
		entity.setBirthDate(t.getBirthDate());
		entity.setEmail(t.getEmail());
		entity.setPassword(t.getPassword());
		entity.setEloPoints(t.getEloPoints());
		entity.setRank(t.getRank());
		return entity;
	}

}
