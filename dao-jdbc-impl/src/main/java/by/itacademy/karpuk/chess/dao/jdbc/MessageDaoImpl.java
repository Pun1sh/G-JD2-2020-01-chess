package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IMessageDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IGame;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMessage;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.dao.api.filter.MessageFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Game;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Message;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Player;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<IMessage, Integer> implements IMessageDao {

	@Override
	public IMessage createEntity() {
		return new Message();
	}

	@Override
	public void insert(IMessage entity) {
		executeStatement(new PreparedStatementAction<IMessage>(
				String.format("insert into %s (writer_id, content, created, game_id) values(?,?,?,?)", getTableName()),
				true) {
			@Override
			public IMessage doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getWriter().getId());
				pStmt.setString(2, entity.getContent());
				pStmt.setObject(3, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setInt(4, entity.getGame().getId());
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
	public void update(IMessage entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IMessage> find(MessageFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(MessageFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected String getTableName() {
		return "message";
	}

	protected IMessage parseRow(final ResultSet resultSet) throws SQLException {
		final IMessage entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setContent(resultSet.getString("content"));
		entity.setCreated(resultSet.getTimestamp("created"));

		final IPlayer player = new Player();
		player.setId((Integer) resultSet.getObject("writer_id"));
		entity.setWriter(player);

		IGame game = new Game();
		game.setId((Integer) resultSet.getObject("game_id"));
		entity.setGame(game);
		return entity;

	}

}
