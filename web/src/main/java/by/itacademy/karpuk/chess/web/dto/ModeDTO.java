package by.itacademy.karpuk.chess.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ModeDTO {

	@Size(min = 1, max = 50)
	private String name;
	@NotNull
	private Integer timeMinutes;
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}