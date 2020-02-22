package by.itacademy.karpuk.chess.dao.api.entity.table;

public interface IMode extends IBaseEntity {
	String getName();

	void setName(String name);

	Integer getTimeMinutes();

	void setTimeMinutes(Integer timeMinutes);
}
