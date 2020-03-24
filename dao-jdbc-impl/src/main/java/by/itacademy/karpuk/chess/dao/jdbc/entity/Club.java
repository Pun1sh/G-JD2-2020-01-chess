package by.itacademy.karpuk.chess.dao.jdbc.entity;

import java.util.Date;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;

public class Club extends BaseEntity implements IClub {
	private String name;
	private Date created;
	private Date deleted;
	private Integer numberOfMembers;
	private ICountry country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfMembers() {
		return numberOfMembers;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public void setNumberOfMembers(Integer numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public ICountry getCountry() {
		return country;
	}

	public void setCountry(ICountry country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Club [name=" + name + ", created=" + created + ", deleted=" + deleted + ", numberOfMembers="
				+ numberOfMembers + ", country=" + country + "]";
	}

}
