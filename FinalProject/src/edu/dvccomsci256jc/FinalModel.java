package edu.dvccomsci256jc;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinalModel implements viewInterface, readAndWriteInterface{
    private Connection connection;
    int userId;
    public FinalModel(int id) {
        // Initialize your database connection here
        connectToDatabase();
        createTableIfNotExists();
        userId = id;
    }

    private void connectToDatabase() {
        // Replace these with your actual database URL, username, and password
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void write() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO progressions (rootChord, secondChord, thirdChord, fourthChord, fifthChord, sixthChord, seventhChord) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)"
        )) {
            preparedStatement.setString(1, userRootChordTf.getText());
            preparedStatement.setString(2, userSecondTf.getText());
            preparedStatement.setString(3, userThirdTf.getText());
            preparedStatement.setString(4, userFourthTf.getText());
            preparedStatement.setString(5, userFifthTf.getText());
            preparedStatement.setString(6, userSixthTf.getText());
            preparedStatement.setString(7, userSeventhTf.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void read() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM progressions ORDER BY id DESC LIMIT 1");

            if (resultSet.next()) {
                setUserProgression(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public List<Label> getUpdatedProgressions() {
        List<Label> updatedProgressions = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM progressions");

            while (resultSet.next()) {
                Label addLabel = new Label("Prog #" + resultSet.getInt("id"));
                addLabel.setStyle("-fx-font-size: 12pt; -fx-text-fill: black;");
                updatedProgressions.add(addLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedProgressions;
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
}
