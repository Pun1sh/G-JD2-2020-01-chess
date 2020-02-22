package by.itacademy.karpuk.chess.dao.jdbc.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IMode;

public class Mode extends BaseEntity implements IMode {
	private String name;
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
}
