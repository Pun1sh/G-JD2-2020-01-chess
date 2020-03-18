package by.itacademy.karpuk.chess.service;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;

public interface IParticipationService {
	IParticipation get(Integer id);

	List<IParticipation> getAll();

	void save(IParticipation entity);

	void delete(Integer id);

	void deleteAll();

	IParticipation createEntity();

	List<IParticipation> find(ParticipationFilter filter);
}
