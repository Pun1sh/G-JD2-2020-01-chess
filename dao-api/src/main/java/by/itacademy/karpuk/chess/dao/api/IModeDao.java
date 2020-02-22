package by.itacademy.karpuk.chess.dao.api;

import java.util.List;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;
import by.itacademy.karpuk.chess.dao.api.filter.ModeFilter;

public interface IModeDao extends IDao<IMode, Integer> {
	List<IMode> find(ModeFilter filter);

	long getCount(ModeFilter filter);
}
