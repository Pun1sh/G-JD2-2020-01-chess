package by.itacademy.karpuk.chess.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import by.itacademy.karpuk.chess.dao.api.entity.table.IClub;
import by.itacademy.karpuk.chess.dao.api.entity.table.ICountry;

@Entity
public class Club extends BaseEntity implements IClub {
	@Column
	private String name;
	@Column
	private Date createdDate;
	@Column
	private Date deletedDate;
	@Column
	private Integer numberOfMembers;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	private ICountry country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Integer getNumberOfMembers() {
		return numberOfMembers;
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
		return "Club [name=" + name + ", createdDate=" + createdDate + ", deletedDate=" + deletedDate
				+ ", numberOfMembers=" + numberOfMembers + ", country=" + country + ", getId()=" + getId() + "]";
	}

}
