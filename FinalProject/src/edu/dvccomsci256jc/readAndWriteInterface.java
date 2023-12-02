package edu.dvccomsci256jc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface readAndWriteInterface {
	public void read();
	public void write();
	public void playSound(String chord);
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/UserDatabase";
    String username = "root";
    String password = "Test1234!";
 
}
