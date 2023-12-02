package edu.dvccomsci256jc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetrieval {
	public static ResultSet getData() throws SQLException{
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/javabook", 
				"root", 
				"Test1234!");
		String query = "select deptId, count(*) from Student\r\n"
				+ "where deptId is not null group by deptId;";
		PreparedStatement prepStatement = connection.prepareStatement(query);
		return prepStatement.executeQuery();
	}
}
