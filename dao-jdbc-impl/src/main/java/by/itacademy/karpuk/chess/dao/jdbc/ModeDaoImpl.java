package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.itacademy.karpuk.chess.dao.api.IModeDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.filter.ModeFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Mode;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

public class ModeDaoImpl extends AbstractDaoImpl<IMode, Integer> implements IModeDao {
	@Override
	public IMode createEntity() {
		return new Mode();
	}

	@Override
	public void insert(IMode entity) {
		executeStatement(new PreparedStatementAction<IMode>(
				String.format("insert into %s (name, time_minutes) values(?,?)", getTableName()), true) {
			@Override
			public IMode doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setInt(2, entity.getTimeMinutes());
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
	public void update(IMode entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IMode> find(ModeFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(ModeFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected IMode parseRow(final ResultSet resultSet) throws SQLException {
		final IMode entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setTimeMinutes(resultSet.getInt("time_minutes"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "mode";
	}
}
