package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IClubDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.filter.ClubFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Club;

@Repository
public class ClubDaoImpl extends AbstractDaoImpl<IClub, Integer> implements IClubDao {

	@Override
	public IClub createEntity() {
		return new Club();
	}

	protected ClubDaoImpl() {
		super(Club.class);
	}

	@Override
	public List<IClub> find(ClubFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(ClubFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
