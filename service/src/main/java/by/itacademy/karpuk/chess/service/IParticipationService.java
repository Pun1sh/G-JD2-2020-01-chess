package by.itacademy.karpuk.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.karpuk.chess.dao.api.entity.table.IParticipation;
import by.itacademy.karpuk.chess.dao.api.filter.ParticipationFilter;

public interface IParticipationService {
	IParticipation get(Integer id);

	List<IParticipation> getAll();

	@Transactional
	void save(IParticipation entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IParticipation createEntity();

	List<IParticipation> find(ParticipationFilter filter);
}
