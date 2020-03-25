package by.itacademy.karpuk.chess.dao.api.entity.enums;

public enum Mode {

	BULLET(1), BLITZ(3), TEN(10), THIRTY(30), SIXTY(60);

	private Integer time;

	Mode(Integer time) {
		this.time = time;
	}

	public Integer getTime() {
		return time;
	}

}
