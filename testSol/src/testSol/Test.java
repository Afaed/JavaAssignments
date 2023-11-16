package testSol;

import java.io.*;

public class Test  {
  public static void main(String[] args) {
    try {
      RandomAccessFile raf =
        new RandomAccessFile("test.dat", "r");
      int i = raf.readInt();
    }
    catch(IOException ex) {
      System.out.println("IO exception");
    }
  }
}

