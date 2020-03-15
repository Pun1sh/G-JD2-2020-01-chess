package by.itacademy.karpuk.chess.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IClubDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Club;
import by.itacademy.karpuk.chess.dao.jdbc.entity.Country;
import by.itacademy.karpuk.chess.dao.jdbc.util.PreparedStatementAction;

@Repository
public class ClubDaoImpl extends AbstractDaoImpl<IClub, Integer> implements IClubDao {

	@Override
	public IClub createEntity() {
		return new Club();
	}

	@Override
	public void insert(IClub entity) {
		executeStatement(new PreparedStatementAction<IClub>(
				String.format("insert into %s (name,created,deleted,number_of_members,country_id) values(?,?,?,?,?)",
						getTableName()),
				true) {
			@Override
			public IClub doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setObject(2, entity.getCreatedDate(), Types.TIMESTAMP);
				if (entity.getDeletedDate() == null) {
					pStmt.setNull(3, java.sql.Types.TIMESTAMP);
				} else {
					pStmt.setObject(3, entity.getDeletedDate(), java.sql.Types.TIMESTAMP);
				}
				pStmt.setInt(4, entity.getNumberOfMembers());
				if (entity.getCountry() == null) {
					pStmt.setNull(5, java.sql.Types.INTEGER);
				} else {
					pStmt.setObject(5, entity.getCountry().getId(), java.sql.Types.INTEGER);
				}

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
	public void update(IClub entity) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	@Override
	public List<IClub> find(ClubFilter filter) {
		return selectAll();
	}

	@Override
	public long getCount(ClubFilter filter) {
		throw new RuntimeException("will be implemented in ORM layer. Too complex for plain jdbc ");
	}

	protected IClub parseRow(final ResultSet resultSet) throws SQLException {
		final IClub entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setCreatedDate(resultSet.getTimestamp("created"));
		entity.setDeletedDate(resultSet.getTimestamp("deleted"));
		entity.setNumberOfMembers(resultSet.getInt("number_of_members"));

		final ICountry country = new Country();
		country.setId((Integer) resultSet.getObject("country_id"));
		entity.setCountry(country);
		return entity;
	}

	@Override
	protected String getTableName() {
		return "club";
	}

}
