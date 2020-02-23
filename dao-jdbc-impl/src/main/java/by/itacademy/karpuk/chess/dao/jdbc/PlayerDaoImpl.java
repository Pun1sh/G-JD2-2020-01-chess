package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IPlayerDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.PlayerFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Club;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Country;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

public class PlayerDaoImpl extends AbstractDaoImpl<IPlayer, Integer> implements IPlayerDao {

	@Override
	public IPlayer createEntity() {
		return new Player();
	}

	@Override
	public void insert(IPlayer entity) {
		executeStatement(new PreparedStatementAction<IPlayer>(String.format(
				"insert into %s (name, surname, nickname, country_id, registrated, club_id, games_played, birth_date, email, password, elo_points, rank) values(?,?,?,?,?,?,?,?,?,?,?,?)",
				getTableName()), true) {
			@Override
			public IPlayer doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setString(2, entity.getSurname());
				pStmt.setString(3, entity.getNickname());
				pStmt.setInt(4, entity.getCountry().getId());
				pStmt.setObject(5, entity.getRegistratedDate(), Types.TIMESTAMP);
				pStmt.setInt(6, entity.getClub().getId());
				pStmt.setInt(7, entity.getGamesPlayed());
				pStmt.setObject(8, entity.getBirthDate(), Types.TIMESTAMP);
				pStmt.setString(9, entity.getEmail());
				pStmt.setString(10, entity.getPassword());
				pStmt.setInt(11, entity.getEloPoints());
				pStmt.setString(12, entity.getRank());
				pStmt.executeUpdate();

				final ResultSet rs = pStmt.getGeneratedKeys();
				rs.next();
				final int id = rs.getInt("id");

				rs.close();

				entity.setId(id);
				return entity;
			}
		});
	}

	@Override
	public void update(IPlayer entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected String getTableName() {
		return "player";
	}

	@Override
	public List<IPlayer> find(PlayerFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(PlayerFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	protected IPlayer parseRow(final ResultSet resultSet) throws SQLException {
		final IPlayer entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setSurname(resultSet.getString("surname"));
		entity.setNickname(resultSet.getString("nickname"));
		entity.setRegistratedDate(resultSet.getTimestamp("registrated"));
		entity.setGamesPlayed(resultSet.getInt("games_played"));
		entity.setBirthDate(resultSet.getTimestamp("birth_date"));
		entity.setEmail(resultSet.getString("email"));
		entity.setPassword(resultSet.getString("password"));
		entity.setEloPoints(resultSet.getInt("elo_points"));
		entity.setRank(resultSet.getString("rank"));

		final ICountry country = new Country();
		country.setId((Integer) resultSet.getObject("country_id"));
		entity.setCountry(country);

		IClub club = new Club();
		club.setId((Integer) resultSet.getObject("club_id"));
		entity.setClub(club);
		return entity;

	}
}
