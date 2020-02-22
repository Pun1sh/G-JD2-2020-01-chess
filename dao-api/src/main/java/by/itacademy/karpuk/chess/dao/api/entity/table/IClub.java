package by.itacademy.karpuk.chess.dao.api.entity.table;

import java.util.Date;

public interface IClub extends IBaseEntity {
	String getName();

	void setName(String name);

	Date getCreatedDate();

	void setCreatedDate(Date createdDate);

	Date getDeletedDate();

	void setDeletedDate(Date deletedDate);

	Integer getNumberOfMembers();

	void setNumberOfMembers(Integer numberOfMembers);

	ICountry getCountry();

	void setCountry(ICountry country);

}
