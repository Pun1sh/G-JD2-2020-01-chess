package by.itacademy.karpuk.chess.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.karpuk.chess.dao.api.IParticipationDao;
import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;
import by.itacademy.karpuk.chess.dao.orm.impl.entity.Participation;

@Repository
public class ParticipationDaoImpl extends AbstractDaoImpl<IParticipation, Integer> implements IParticipationDao {

	@Override
	public IParticipation createEntity() {
		return new Participation();
	}

	protected ParticipationDaoImpl() {
		super(Participation.class);
	}

	@Override
	public List<IParticipation> find(ParticipationFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount(ParticipationFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
