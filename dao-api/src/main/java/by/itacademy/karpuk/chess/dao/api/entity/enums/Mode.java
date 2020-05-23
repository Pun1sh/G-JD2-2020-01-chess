package by.itacademy.karpuk.chess.dao.api.entity.enums;

public enum Mode {

	BLITZ(3), TEN(10), THIRTY(30), SIXTY(60), NO_TIME();

	private Integer time;

	Mode(Integer time) {
		this.time = time;
	}

	Mode() {
		
	}

	public Integer getTime() {
		return time;
	}

}
