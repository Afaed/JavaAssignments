package edu.dvccomsci256jc;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class FinalModel implements viewInterface, readAndWriteInterface{
    int userId;
    
    //Creates database but for the situation we want to use only some of the non database functions
    public FinalModel() {
    	
    }
    public FinalModel(int id) {
        // Initialize your database connection here
        connectToDatabase();
        createTableIfNotExists();
        userId = id;
    }

    private void connectToDatabase() {
        // Replace these with your actual database URL, username, and password
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() {
    	try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        try (Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS progressions (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "rootChord VARCHAR(255)," +
                    "secondChord VARCHAR(255)," +
                    "thirdChord VARCHAR(255)," +
                    "fourthChord VARCHAR(255)," +
                    "fifthChord VARCHAR(255)," +
                    "sixthChord VARCHAR(255)," +
                    "seventhChord VARCHAR(255)" +
                    ")";
            statement.executeUpdate(createTableQuery);
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void write() {
    	try (
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
        try (PreparedStatement preparedStatement = connection.prepareStatement
        		(
                "INSERT INTO progressions ("
                + "id"
                + "rootChord "
                + "secondChord, "
                + "thirdChord, "
                + "fourthChord, "
                + "fifthChord, "
                + "sixthChord, "
                + "seventhChord) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);"
                + "UPDATE progressions SET id = ?;"
        		)
        	) 
        {	
            preparedStatement.setString(1, userRootChordTf.getText());
            preparedStatement.setString(2, userSecondTf.getText());
            preparedStatement.setString(3, userThirdTf.getText());
            preparedStatement.setString(4, userFourthTf.getText());
            preparedStatement.setString(5, userFifthTf.getText());
            preparedStatement.setString(6, userSixthTf.getText());
            preparedStatement.setString(7, userSeventhTf.getText());
            preparedStatement.setInt(8, userId);
            preparedStatement.executeUpdate();
        }
            } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }
    
    @Override
    public void read() {
    	try (
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
        try (Statement statement = connection.createStatement()) 
        {
            ResultSet resultSet = statement.executeQuery
            		(
            		"SELECT id FROM progressions WHERE id = " 
            		+ userId
            		);
             {
                setUserProgression(resultSet);
             }
    	} 
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void save() {
    	try (
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
    	try(Statement s = connection.createStatement()){
    		String updateQuery = 
    				"UPDATE progressions SET "
    				+ "rootChord = ?, "
    				+ "secondChord = ?, "
    				+ "thirdChord = ?, "
    				+ "fourthChord = ?, "
    				+ "fifthChord = ?, "
    				+ "sixthChord = ?, "
    				+ "seventhChord = ?"
    				+ "WHERE id = ?";/// + userId + ";";
    		try (PreparedStatement p = connection.prepareStatement(updateQuery)){
    		      p.setString(1, userRootChordTf.getText());
    		      p.setString(2, userSecondTf.getText());
    		      p.setString(3, userThirdTf.getText());
    		      p.setString(4, userFourthTf.getText());
    		      p.setString(5, userFifthTf.getText());
    		      p.setString(6, userSixthTf.getText());
    		      p.setString(7, userSeventhTf.getText());
    		      p.setInt(8, userId);

    		      p.executeUpdate();
    			}
    		}	
    	} catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    }

    private void setUserProgression(ResultSet resultSet) throws SQLException {
        userRootChordTf.setText(resultSet.getString("rootChord"));
        userSecondTf.setText(resultSet.getString("secondChord"));
        userThirdTf.setText(resultSet.getString("thirdChord"));
        userFourthTf.setText(resultSet.getString("fourthChord"));
        userFifthTf.setText(resultSet.getString("fifthChord"));
        userSixthTf.setText(resultSet.getString("sixthChord"));
        userSeventhTf.setText(resultSet.getString("seventhChord"));
    }

	@Override
	public void playSound(String chord) {
	    // TODO Auto-generated method stub
		
	    switch(chord) {
	        case "A":
	            String Apath = "/edu.dvccomsci256jc/sounds/guitar-chord-a-major_140bpm_A_major.wav";
	            PlayMusic(Apath);
	            // use media player for A chord sound
	            break;
	        case "B":
	            // play B chord
	        	String Bpath = "/edu.dvccomsci256jc/sounds/guitar-chord-b-major_140bpm_B_major.wav";        
	        	PlayMusic(Bpath);
	            break;
	        case "C":
	        	String Cpath = "/edu.dvccomsci256jc/sounds/guitar-chord-c-major_140bpm_C_major.wav";
	            
	        	PlayMusic(Cpath);
	            // use media player for C chord sound
	            break;
	        case "D":
	        	String Dpath = "/edu.dvccomsci256jc/sounds/guitar-chord-d-major_140bpm_D_major.wav";
	            PlayMusic(Dpath);
	            // use media player for D chord sound
	            break;
	        case "E":
	        	String Epath = "/edu.dvccomsci256jc/sounds/guitar-chord-e-major_140bpm_E_major.wav";
	            PlayMusic(Epath);
	            // use media player for E chord sound
	            break;
	        case "F":
	        	String Fpath = "/edu.dvccomsci256jc/sounds/guitar-chord-f-major_140bpm_F_major.wav";
	            PlayMusic(Fpath);
	            // use media player for F chord sound
	            break;
	        case "G":
	        	String Gpath = "/edu.dvccomsci256jc/sounds/guitar-chord-g-major_140bpm_G_major.wav";
	            PlayMusic(Gpath);
	            // use media player for G chord sound
	            break;
	        case "Am":
	        case "am":
	        	 String Ampath = "/edu.dvccomsci256jc/sounds/guitar-chord-a-minor_140bpm_A_minor.wav";
		         PlayMusic(Ampath);
	            // use media player for A minor chord sound
	            break;
	        case "Bm":
	        case "bm":
	            String Bmpath = "/edu.dvccomsci256jc/sounds/guitar-chord-b-minor_140bpm_B_minor.wav";
	            PlayMusic(Bmpath);
	            // use media player for B minor chord sound
	            break;
	        case "Cm":
	        case "cm":
	            String Cmpath = "/edu.dvccomsci256jc/sounds/guitar-chord-c-minor_140bpm_C_minor.wav";
	            PlayMusic(Cmpath);
	            // use media player for C minor chord sound
	            break;
	        case "Dm":
	        case "dm":
	        	String Dmpath = "/edu.dvccomsci256jc/sounds/guitar-chord-d-minor_140bpm_D_minor.wav";
	        	PlayMusic(Dmpath);
	        	break;
	        case "Em":
	        case "em":
	        	String Empath = "/edu.dvccomsci256jc/sounds/guitar-chord-e-minor_140bpm_E_minor.wav";
	        	PlayMusic(Empath);
	        	break;
	        
	        case "Fm":
	        case "fm":
	        	String Fmpath = "/edu.dvccomsci256jc/sounds/guitar-chord-f-minor_140bpm_F_minor.wav";
	        	PlayMusic(Fmpath);
	        	break;
	        
	        case "Gm":
	        case "gm":
	        	String Gmpath = "/edu.dvccomsci256jc/sounds/guitar-chord-g-minor_140bpm_G_minor.wav";
	        	PlayMusic(Gmpath);
	        	break;
	        // Add more cases for other chords as needed
	        default:
	            displayErrorMessage("Sound not found");
	    }
	}

	private void PlayMusic(String location) {
	    new Thread(() -> {
	        try {
	            File musicPath = new File(location);

	            if (musicPath.exists()) {
	                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicPath);
	                Clip clip = AudioSystem.getClip();
	                clip.open(audioInputStream);
	                clip.start();
	                clip.loop(1000);
	                // Sleep for a while to allow the sound to play
	                Thread.sleep(5000); // Adjust the sleep time as needed
	                clip.stop();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }).start();
	}
	
	void displayErrorMessage(String errorMessage){
		new Alert(Alert.AlertType.ERROR, errorMessage).showAndWait();
		}

	public void delete(int id){
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM progressions WHERE id = ?;";
		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password))
				{
		try (PreparedStatement p = connection.prepareStatement(deleteQuery)){
			p.setInt(1,  id);
			p.executeUpdate();
		}
		} catch(SQLException ex) {
			displayErrorMessage("File can not be found");
		}
	}

	public void loadLast(int pos) {
		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password))
				{
		try (Statement statement = connection.createStatement()) {
	        // Retrieve the latest record by ordering by id in descending order
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM progressions WHERE id = " + pos + ";");

	        if (resultSet.next()) {
	            setUserProgression(resultSet);
	        }
	    } 
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getUserRootChord() {
        return userRootChordTf.getText();
    }
	public void next(int pos) {
	    String nextQuery = "SELECT * FROM progressions WHERE id = ?;";
	    
	    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(nextQuery)) {
	            preparedStatement.setInt(1, pos);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    setUserProgression(resultSet);
	                } else {
	                    displayErrorMessage("No more progressions found");
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            displayErrorMessage("Error retrieving next progression");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        displayErrorMessage("Database connection error");
	    }
	}

}
