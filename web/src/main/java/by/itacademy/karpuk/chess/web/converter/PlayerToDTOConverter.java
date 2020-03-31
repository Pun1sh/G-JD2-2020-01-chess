package by.itacademy.karpuk.chess.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.web.dto.PlayerDTO;

@Component
public class PlayerToDTOConverter implements Function<IPlayer, PlayerDTO> {

	@Override
	public PlayerDTO apply(IPlayer player) {
		PlayerDTO dto = new PlayerDTO();
		dto.setId(player.getId());
		dto.setNickname(player.getNickname());
		if (!(player.getCountry() == null)) {
			dto.setCountryId(player.getCountry().getId());
		}
		if (!(player.getClub() == null)) {
			dto.setCountryId(player.getClub().getId());
		}
		dto.setRegistrated(player.getRegistrated());
		dto.setGamesPlayed(player.getGamesPlayed());
		dto.setBirthDate(player.getBirthDate());
		dto.setEmail(player.getEmail());
		dto.setPassword(player.getPassword());
		dto.setEloPoints(player.getEloPoints());
		dto.setRank(player.getRank());
		return dto;
	}

}
