package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IParticipationDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.entity.table.ITournament;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Participation;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Tournament;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
public class ParticipationDaoImpl extends AbstractDaoImpl<IParticipation, Integer> implements IParticipationDao {

	@Override
	public IParticipation createEntity() {
		return new Participation();
	}

	@Override
	public void insert(IParticipation entity) {
		executeStatement(new PreparedStatementAction<IParticipation>(String.format(
				"insert into %s (player_id, tournament_id, tournament_points) values(?,?,?)", getTableName()), true) {
			@Override
			public IParticipation doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getPlayer().getId());
				pStmt.setInt(2, entity.getTournament().getId());
				pStmt.setInt(3, entity.getTournamentPoints());

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
	public void update(IParticipation entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IParticipation> find(ParticipationFilter filter) {
		return selectAll();

	}

	@Override
	public long getCount(ParticipationFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	protected String getTableName() {
		return "player_tournament_participation";
	}

	protected IParticipation parseRow(final ResultSet resultSet) throws SQLException {
		final IParticipation entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setTournamentPoints(resultSet.getInt("tournament_points"));

		final IPlayer player = new Player();
		player.setId((Integer) resultSet.getObject("player_id"));
		entity.setPlayer(player);

		ITournament tournament = new Tournament();
		tournament.setId((Integer) resultSet.getObject("tournament_id"));
		entity.setTournament(tournament);
		return entity;

	}

}
