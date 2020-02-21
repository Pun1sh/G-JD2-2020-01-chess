package by.itacademy.karpuk.chess.dao.jdbc.util;

import java.sql.SQLException;
import java.sql.Statement;

@FunctionalInterface
public interface StatementAction<RETURN_TYPE> {

	RETURN_TYPE doWithStatement(Statement stmt) throws SQLException;

}