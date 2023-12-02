package edu.dvccomsci256jc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Contains the  methods and tools to generate a chord progresstions
public class Chords {
	private String chord;
	ArrayList<String> chordOrder;
	private String keyRoot;
	
	public Chords(String chord) {
		chord = this.chord;
		keyRootChord();
	}
	
	public String keyRootChord() {
		return keyRoot = chord;
		}
	

	//This generates a chord progresssion to be used in the recommendation pannel.
    public ArrayList<String> generateChordProg() {
        chordOrder.clear(); // Clear the chordOrder list before generating a new progression
        
        //TO DO: Finish establishing connection of database. probably add it to javabooks?
        //Also-add username and password for later. 
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
	     String username = "your_username";
	     String password = "your_password";
	     
	     try(Connection c = DriverManager.getConnection(jdbcUrl, username, password)) {
	    	 String getQuery = "SELECT I, II, III, IV, V, VI, VII FROM chords WHERE I = " + keyRoot; //Query statement
	    	 try (PreparedStatement prep = c.prepareStatement(getQuery))//Preoared statement
	    	 {
	    		 try(ResultSet r = prep.executeQuery()) //the result set
	    		 {
		    		 while(r.next())
		    		 {
		    		 chordOrder.add(r.getString(keyRoot)); //adds the results to the chord order. 
		    		 }
	    		 }
	    	 }
	     } catch (SQLException ex) {
	    	 ex.printStackTrace();
	       }

        return chordOrder;
    }

    //This plays a sound of the chord. Might have to make a database for this too.
	public void playSound() {
		
	}
}