package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;

@Entity
public class Mode extends BaseEntity implements IMode {
	@Column
	private String name;
	@Column
	private Integer timeMinutes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTimeMinutes() {
		return timeMinutes;
	}

	public void setTimeMinutes(Integer timeMinutes) {
		this.timeMinutes = timeMinutes;
	}

	@Override
	public String toString() {
		return "Mode [name=" + name + ", timeMinutes=" + timeMinutes + ", getName()=" + getName()
				+ ", getTimeMinutes()=" + getTimeMinutes() + ", getId()=" + getId() + "]";
	}

}
