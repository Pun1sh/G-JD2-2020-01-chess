package by.itacademy.karpuk.chess.dao.jdbc.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IBaseEntity;

public abstract class BaseEntity implements IBaseEntity {
	private Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

}