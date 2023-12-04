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
		chordOrder = new ArrayList<String>();
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
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/chordBase";
	     String username = "root";
	     String password = "Test1234!";
	     
	     try(Connection c = DriverManager.getConnection(jdbcUrl, username, password)) {
	    	 String getQuery = "SELECT I, II, III, IV, V, VI, VII FROM chords WHERE I = '" + keyRoot + "'";
	    	 try (PreparedStatement prep = c.prepareStatement(getQuery)) {
	    		    // No need to set parameters, as they are directly included in the SQL query

	    		    try (ResultSet r = prep.executeQuery()) {
	    		        if (r.next()) {
	    		            // Add all columns to the generatedChords list
	    		            for (int i = 1; i <= 7; i++) {
	    		                chordOrder.add(r.getString(i));
	    		            }
	    		        }
	    		    }
	    		}
	     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chordOrder;
    }
}