package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IGameDao;
import by.itacademy.karpuk.chess.dao.api.entity.enums.Mode;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.GameFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Game;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Tournament;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
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
				if (entity.getTournament() == null) {
					pStmt.setNull(3, java.sql.Types.INTEGER);
				} else {
					pStmt.setObject(3, entity.getTournament().getId(), java.sql.Types.INTEGER);
				}
				if (entity.getWinner() == null) {
					pStmt.setNull(4, java.sql.Types.INTEGER);
				} else {
					pStmt.setObject(4, entity.getWinner().getId(), java.sql.Types.INTEGER);
				}
				if (entity.getLoser() == null) {
					pStmt.setNull(5, java.sql.Types.INTEGER);
				} else {
					pStmt.setObject(5, entity.getLoser().getId(), java.sql.Types.INTEGER);
				}
				pStmt.setObject(6, entity.getStarted(), Types.TIMESTAMP);
				if (entity.getEnded() == null) {
					pStmt.setNull(7, java.sql.Types.TIMESTAMP);
				} else {
					pStmt.setObject(7, entity.getEnded(), java.sql.Types.TIMESTAMP);
				}
				pStmt.setObject(8, entity.getMode());

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
		entity.setMode((Mode) resultSet.getObject("mode"));

		IPlayer whitePlayer = new Player();
		whitePlayer.setId((Integer) resultSet.getObject("white_player_id"));
		entity.setWhitePlayer(whitePlayer);

		IPlayer blackPlayer = new Player();
		blackPlayer.setId((Integer) resultSet.getObject("black_player_id"));
		entity.setBlackPlayer(blackPlayer);

		IPlayer winner = new Player();
		winner.setId((Integer) resultSet.getObject("winner_id"));
		entity.setWinner(winner);

		IPlayer loser = new Player();
		loser.setId((Integer) resultSet.getObject("loser_id"));
		entity.setLoser(loser);

		final ITournament tournament = new Tournament();
		tournament.setId((Integer) resultSet.getObject("tournament_id"));
		entity.setTournament(tournament);

		return entity;

	}

	@Override
	public void update(IGame entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IGame> find(GameFilter filter) {
		return selectAll();
	}

	@Override
	public long getCount(GameFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected String getTableName() {
		return "game";
	}

	@Override
	public IGame getFullInfo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
