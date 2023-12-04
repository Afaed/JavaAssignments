package edu.dvccomsci256jc;


public interface readAndWriteInterface {
	public void read();
	public void write();
	public void playSound(String chord);
	public void save();
	String jdbcUrl = "jdbc:mysql://localhost:3306/chordBase";
    String username = "root";
    String password = "Test1234!";
 
}
