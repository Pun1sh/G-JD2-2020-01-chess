package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IGameDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Game;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Mode;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Tournament;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

public class GameDaoImpl extends AbstractDaoImpl<IGame, Integer> implements IGameDao {

	@Override
	public IGame createEntity() {
		return new Game();
	}

	@Override
	public void insert(IGame entity) {
		executeStatement(new PreparedStatementAction<IGame>(String.format(
				"insert into %s (white_player_id, black_player_id, tournament_id, winner_id, loser_id, started, ended, mode_id) values(?,?,?,?,?,?,?,?)",
				getTableName()), true) {
			@Override
			public IGame doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getWhitePlayer().getId());
				pStmt.setInt(2, entity.getBlackPlayer().getId());
				pStmt.setInt(3, entity.getTournament().getId());
				pStmt.setInt(4, entity.getWinner().getId());
				pStmt.setInt(5, entity.getLoser().getId());
				pStmt.setObject(6, entity.getStarted(), Types.TIMESTAMP);
				pStmt.setObject(7, entity.getEnded(), Types.TIMESTAMP);
				pStmt.setInt(8, entity.getMode().getId());

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

	protected IGame parseRow(final ResultSet resultSet) throws SQLException {
		final IGame entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setStarted(resultSet.getTimestamp("started"));
		entity.setEnded(resultSet.getTimestamp("ended"));

		IPlayer player = new Player();
		player.setId((Integer) resultSet.getObject("white_player_id"));
		player.setId((Integer) resultSet.getObject("black_player_id"));
		player.setId((Integer) resultSet.getObject("winner_id"));
		player.setId((Integer) resultSet.getObject("loser_id"));

		final ITournament tournament = new Tournament();
		tournament.setId((Integer) resultSet.getObject("tournament_id"));
		entity.setTournament(tournament);
		IMode mode = new Mode();
		mode.setId((Integer) resultSet.getObject("mode_id"));
		entity.setMode(mode);

		return entity;

	}

	@Override
	public void update(IGame entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IGame> find(GameFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(GameFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected String getTableName() {
		return "game";
	}

}
