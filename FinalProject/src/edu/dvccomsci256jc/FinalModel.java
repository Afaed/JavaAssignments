package edu.dvccomsci256jc;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinalModel implements viewInterface, readAndWriteInterface{
    int userId;
    
    //Creates database but for the situation we want to use only some of the non database functions
    public FinalModel() {
    	connectToDatabase();
        createTableIfNotExists();
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
                "INSERT INTO progressions (rootChord, "
                + "secondChord, "
                + "thirdChord, "
                + "fourthChord, "
                + "fifthChord, "
                + "sixthChord, "
                + "seventhChord) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?);"
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
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id FROM progressions WHERE id = " + userId);

            if (resultSet.next()) {
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
    				+ "WHERE id = " + userId + ";";
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
		switch(chord) 
		{
		case "A":
			//play A chord
			//use media player
			break;
		default:
			displayErrorMessage("Sound not found");
		}
		
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
		String  nextQuery = "SELECT * FROM progressions WHERE id = " + pos + ";";
		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password))
				{
		try(Statement s = connection.prepareStatement(nextQuery)){
			
		} catch(SQLException ex) {
			displayErrorMessage("Error detected! Can't go further");
		};
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
