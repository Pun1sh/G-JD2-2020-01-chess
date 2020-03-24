package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IMoveDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMove;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.MoveFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Game;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Move;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
public class MoveDaoImpl extends AbstractDaoImpl<IMove, Integer> implements IMoveDao {

	@Override
	public IMove createEntity() {
		return new Move();
	}

	@Override
	public void insert(IMove entity) {
		executeStatement(new PreparedStatementAction<IMove>(String.format(
				"insert into %s (game_id, player_id, piece_id, move_notation_from, move_notation_to, move_time) values(?,?,?,?,?,?)",
				getTableName()), true) {
			@Override
			public IMove doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getGame().getId());
				pStmt.setInt(2, entity.getPlayer().getId());
				pStmt.setObject(3, entity.getPiece());
				pStmt.setString(4, entity.getMoveNotationFrom());
				pStmt.setString(5, entity.getMoveNotationTo());
				pStmt.setInt(6, entity.getMoveTime());
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
	public void update(IMove entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	protected String getTableName() {
		return "move";
	}

	@Override
	public List<IMove> find(MoveFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(MoveFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	protected IMove parseRow(final ResultSet resultSet) throws SQLException {
		final IMove entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setMoveNotationFrom(resultSet.getString("move_notation_from"));
		entity.setMoveNotationTo(resultSet.getString("move_notation_to"));
		entity.setMoveTime(resultSet.getInt("move_time"));

		IGame game = new Game();
		game.setId((Integer) resultSet.getObject("game_id"));
		entity.setGame(game);

		IPlayer player = new Player();
		player.setId((Integer) resultSet.getObject("player_id"));
		entity.setPlayer(player);

		return entity;

	}

}
