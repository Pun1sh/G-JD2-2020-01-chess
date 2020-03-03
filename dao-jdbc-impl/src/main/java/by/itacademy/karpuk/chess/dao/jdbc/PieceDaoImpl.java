package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IPieceDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;
import by.itacademy.karpuk.chess.dao.api.filter.PieceFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Piece;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
public class PieceDaoImpl extends AbstractDaoImpl<IPiece, Integer> implements IPieceDao {

	@Override
	public IPiece createEntity() {
		return new Piece();
	}

	@Override
	public void insert(IPiece entity) {
		executeStatement(new PreparedStatementAction<IPiece>(
				String.format("insert into %s (name) values(?)", getTableName()), true) {
			@Override
			public IPiece doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
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
	public void update(IPiece entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");

	}

	@Override
	public List<IPiece> find(PieceFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public long getCount(PieceFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	protected IPiece parseRow(final ResultSet resultSet) throws SQLException {
		final IPiece entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "piece";
	}

}
