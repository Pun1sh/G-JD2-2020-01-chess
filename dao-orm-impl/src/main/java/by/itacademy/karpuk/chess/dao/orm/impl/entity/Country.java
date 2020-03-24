package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;

@Entity
public class Country extends BaseEntity implements ICountry {
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
