package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;

public interface IPlayerService {
	IPlayer get(Integer id);

	List<IPlayer> getAll();

	@Transactional
	void save(IPlayer entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IPlayer createEntity();

	List<IPlayer> find(PlayerFilter filter);

	IPlayer getFullInfo(Integer id);

	IPlayer getPlayerByNickname(String nickname);

	@Transactional
	List<IPlayer> search(String string);

	long getCount(PlayerFilter filter);
	
	List<IPlayer> findWithoutLoggedPlayer(PlayerFilter filter,Integer loggedPlayerId);
	

}
