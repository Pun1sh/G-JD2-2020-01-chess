package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;

public class Piece extends BaseEntity implements IPiece {
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Piece [name=" + name + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}

}
