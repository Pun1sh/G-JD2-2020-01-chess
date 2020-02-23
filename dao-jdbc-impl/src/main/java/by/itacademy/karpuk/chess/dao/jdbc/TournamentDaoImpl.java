package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import by.itacademy.karpuk.chess.dao.api.ITournamentDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.TournamentFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Country;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Tournament;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

public class TournamentDaoImpl extends AbstractDaoImpl<ITournament, Integer> implements ITournamentDao {

	@Override
	public ITournament createEntity() {
		return new Tournament();
	}

	@Override
	public void insert(ITournament entity) {
		executeStatement(new PreparedStatementAction<ITournament>(
				String.format("insert into %s (name, started, ended, country_id, winner_id) values(?,?,?,?,?)",
						getTableName()),
				true) {
			@Override
			public ITournament doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setObject(2, entity.getStarted(), Types.TIMESTAMP);
				pStmt.setObject(3, entity.getEnded(), Types.TIMESTAMP);
				pStmt.setInt(4, entity.getCountry().getId());
				pStmt.setInt(5, entity.getWinner().getId());

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

	protected ITournament parseRow(final ResultSet resultSet) throws SQLException {
		final ITournament entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setStarted(resultSet.getTimestamp("started"));
		entity.setEnded(resultSet.getTimestamp("ended"));

		final ICountry country = new Country();
		country.setId((Integer) resultSet.getObject("country_id"));
		entity.setCountry(country);

		IPlayer winner = new Player();
		winner.setId((Integer) resultSet.getObject("winner_id"));
		entity.setWinner(winner);
		return entity;
	}

	@Override
	public void update(ITournament entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<ITournament> find(TournamentFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public long getCount(TournamentFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	protected String getTableName() {
		return "tournament";
	}

}
