package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;

@Component
public class PlayerToDTOConverter implements Function<IPlayer, PlayerDTO> {

	@Override
	public PlayerDTO apply(IPlayer t) {
		PlayerDTO dto = new PlayerDTO();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setSurname(t.getSurname());
		dto.setNickname(t.getNickname());
		dto.setCountryId(t.getCountry().getId());
		dto.setRegistratedDate(t.getRegistrated());
		dto.setClubId(t.getClub().getId());
		dto.setGamesPlayed(t.getGamesPlayed());
		dto.setBirthDate(t.getBirthDate());
		dto.setEmail(t.getEmail());
		dto.setPassword(t.getPassword());
		dto.setEloPoints(t.getEloPoints());
		dto.setRank(t.getRank());
		return dto;
	}

}
