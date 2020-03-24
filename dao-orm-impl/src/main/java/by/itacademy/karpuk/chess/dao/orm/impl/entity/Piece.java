package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPiece;

@Entity
public class Piece extends BaseEntity implements IPiece {
	@Column
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
