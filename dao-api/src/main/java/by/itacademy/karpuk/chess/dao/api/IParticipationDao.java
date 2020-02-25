package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;

public interface IParticipationDao extends IDao<IParticipation, Integer> {
	List<IParticipation> find(ParticipationFilter filter);

	long getCount(ParticipationFilter filter);
}
