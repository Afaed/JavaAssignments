/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdvJava8 extends Application {
	final int album = 32;
	final int artists = 32;
	final int format = 10;
	final int tracks = 2;
	final int length = 6;
	final int years =  4;
	protected int count = 0;
	protected AlbumPane pane = new AlbumPane();
	
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		pane.addBtn.setOnAction(e -> add());
		pane.firstBtn.setOnAction(e -> first());
		pane.previousBtn.setOnAction(e -> previous());
		pane.lastBtn.setOnAction(e -> last());
		pane.clearBtn.setOnAction(e-> clear());
		pane.updateBtn.setOnAction(e -> update());
		pane.nextBtn.setOnAction(e -> next());
		
		Scene scene = new Scene(pane, 750, 150);
		primaryStage.setTitle("Java Assignment 8");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main (String [] args) {
		launch(args);
	}
	
	public void add() {

	    try (RandomAccessFile raf = new RandomAccessFile("album.dat", "rw")) {
	        if (isValidInput()) {
	   
	            
	            raf.seek(raf.length() / 96);
//	            System.out.println((int)	raf.length()/96);
//	            System.out.println(raf.getFilePointer());
	            write(raf);
	            
	            System.out.println("saving: " + count);
	            count++;
	            clearTextFields();
	        } else {
	            displayErrorMessage("Invalid input. Check text fields");
	        }
	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


	public void first() {
		try(
			RandomAccessFile raf = new RandomAccessFile("album.dat", "rw");
			) {
			
			if(raf.length() > 0) {
				raf.seek(0);
				read(raf);
				count = 1;
			}
			 else {
				displayErrorMessage("This is the end of the file!");
			}
		}
		catch (IOException ex) {}
	}
	
	//last record in file
	public void last() {
	    try (RandomAccessFile raf = new RandomAccessFile("album.dat", "rw");) {
	        if (raf.length() > 0) {
	            count = (int) (raf.length() / 96); // Calculate the last record
	            raf.seek((count - 1) * 96);
	            read(raf);
	            System.out.println("visiting: file# " + count);
	        } else {
	            displayErrorMessage("This is the end of the file!");
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

	public void clear() {
	    try (RandomAccessFile raf = new RandomAccessFile("album.dat", "rw");) {
	        long recordPosition = count > 0 ? (count - 1) * 96 : 0; // Ensure non-negative position
	        if (raf.length() > recordPosition) {
	            raf.seek(recordPosition);
	            byte[] clearBytes = new byte[96];
	            raf.write(clearBytes);
	            clearTextFields();
	        } else {
	            displayErrorMessage("No records to clear");
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


	
	public void next() {
	    try (RandomAccessFile raf = new RandomAccessFile("album.dat", "rw");) {
	        if (count < raf.length() / 96) {
	            raf.seek(count * 96);
	            read(raf);
	            count++;
	            System.out.println("visiting: file# " + count);
	        } else {
	            displayErrorMessage("This is the end of the file!");
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	//previous record
	public void previous() {
	    if (count > 1) {
	        try (RandomAccessFile raf = new RandomAccessFile("album.dat", "rw");) {
	            count--; // Decrease the count to move to the previous record
	            raf.seek((count - 1) * 96); // Adjust the file pointer to the start of the previous record
	            read(raf);
	            System.out.println("visiting: file# " + count);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    } else {
	        displayErrorMessage("This is the beginning of the file!");
	    }
	}

	
	public void update() {
		try(RandomAccessFile raf = 
				new RandomAccessFile("album.dat", "rw");
				){
			raf.seek(count * 96 - 96);
			write(raf);
			System.out.println("Updating: " + count);
		} 
		catch(FileNotFoundException ex) {}
		catch(IOException ex) {
		} catch(ArrayIndexOutOfBoundsException ex) {
			displayErrorMessage("Error one of the fields is too long!");
		}
	}
	
	private void write(RandomAccessFile raf) throws IOException {
	    // Write each field as a fixed-length string with padding
	    raf.write(fixedLength(pane.tfAlbumName.getText().getBytes(), album));
	    raf.write(fixedLength(pane.tfArtistName.getText().getBytes(), artists));
	    raf.write(fixedLength(pane.tfFormatType.getText().getBytes(), format));
	    raf.write(fixedLength(pane.tfNumberOfTracks.getText().getBytes(), tracks));
	    raf.write(fixedLength(pane.tfDuration.getText().getBytes(), length));
	    raf.write(fixedLength(pane.tfYear.getText().getBytes(), years));
	}

	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n];
		for (int i = 0; i < x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}
	
	private void read(RandomAccessFile raf) throws IOException{
		int pos;
		byte [] albumName = new byte[album];
		pos = raf.read(albumName);
		pane.tfAlbumName.setText(new String (albumName));		
		
		byte[] artistName = new byte[artists];
		pos += raf.read(artistName);
		pane.tfArtistName.setText(new String(artistName));
		
		byte[] formatType = new byte[format];
		pos += raf.read(formatType);
		pane.tfFormatType.setText(new String(formatType));
		
		byte[] trackNumber = new byte[tracks];
		pos += raf.read(trackNumber);
		pane.tfNumberOfTracks.setText(new String(trackNumber));
	
		byte[] duration = new byte[length];
		pos += raf.read(duration);
		pane.tfDuration.setText(new String(duration));
		
		byte[] year = new byte[years];
		pos += raf.read(year);
		pane.tfYear.setText(new String(year));
		
	}
	
	void displayErrorMessage(String errorMessage){
		new Alert(Alert.AlertType.ERROR, errorMessage).showAndWait();
		}
	
	private boolean isValidInput() {
	    return pane.tfAlbumName.getText().length() <= album &&
	           pane.tfArtistName.getText().length() <= artists &&
	           pane.tfFormatType.getText().length() <= format &&
	           pane.tfNumberOfTracks.getText().length() <= tracks &&
	           pane.tfDuration.getText().length() <= length &&
	           pane.tfYear.getText().length() <= years;
	}

	private void clearTextFields() {
	    pane.tfAlbumName.clear();
	    pane.tfArtistName.clear();
	    pane.tfFormatType.clear();
	    pane.tfNumberOfTracks.clear();
	    pane.tfDuration.clear();
	    pane.tfYear.clear();
	}

}
