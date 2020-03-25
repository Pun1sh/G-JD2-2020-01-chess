package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IBoardDao;
import by.itacademy.karpuk.chess.dao.api.entity.enums.Piece;
import by.itacademy.karpuk.chess.dao.api.entity.table.IBoard;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.filter.BoardFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Board;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Game;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
public class BoardDaoImpl extends AbstractDaoImpl<IBoard, Integer> implements IBoardDao {

	@Override
	public IBoard createEntity() {
		return new Board();
	}

	@Override
	public void insert(IBoard entity) {
		executeStatement(new PreparedStatementAction<IBoard>(
				String.format("insert into %s (game_id, piece_id, position_letter, position_number) values(?,?,?,?)",
						getTableName()),
				true) {
			@Override
			public IBoard doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getGame().getId());
				pStmt.setObject(2, entity.getPiece());
				pStmt.setString(3, entity.getPositionLetter());
				pStmt.setInt(4, entity.getPositionNumber());
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
	public void update(IBoard entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IBoard> find(BoardFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(BoardFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected String getTableName() {
		return "board";
	}

	protected IBoard parseRow(final ResultSet resultSet) throws SQLException {
		final IBoard entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setPiece((Piece) resultSet.getObject("piece"));
		entity.setPositionLetter(resultSet.getString("position_letter"));
		entity.setPositionNumber(resultSet.getInt("position_number"));

		final IGame game = new Game();
		game.setId((Integer) resultSet.getObject("game_id"));
		entity.setGame(game);

		return entity;

	}

	@Override
	public IBoard getFullInfo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
