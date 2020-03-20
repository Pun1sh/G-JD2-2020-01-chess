package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;

public class Country extends BaseEntity implements ICountry {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
