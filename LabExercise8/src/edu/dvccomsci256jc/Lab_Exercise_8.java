/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import java.io.*;

public class Lab_Exercise_8 {
    public static void main(String[] args) {
        String source = args[0];
        String target = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
                DataOutputStream writer = new DataOutputStream(new FileOutputStream(target))
             ){        	
            	 String line;
            
            while ((line = reader.readLine()) != null) {
              byte[] bytes = line.getBytes("UTF-8");
              writer.writeInt(bytes.length);
              writer.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       File input = new File(source);
       File output = new File(target);
       
       System.out.println("Text file size:  " + input.length());
       System.out.println("UTF File size: " + output.length());
   }
}
//	try(
//	BufferedInputStream txtIn = new BufferedInputStream
//			(new FileInputStream(txtFile));
//	BufferedInputStream utfIn = new BufferedInputStream(
//			(new FileInputStream(utfFile)));
//	BufferedOutputStream txtOut = new BufferedOutputStream(
//			(new FileOutputStream(txtFile)));
//	BufferedOutputStream utfOut = new BufferedOutputStream(
//			(new FileOutputStream(utfFile)));
//		)
//	{
//		int r, byteSize = 0;
//		while((r = txtIn.read()) != -1){
//			txtOut.write((byte) r);
//			byteSize++;
//		}
//		System.out.println("Lab_Exercise8_1.txt's size is " + byteSize);
//		
//		while((r = utfIn.read()) != -1){
//			utfOut.write((byte) r);
//			byteSize++;
//		}
//		System.out.println("Lab_Exercise8_1.utf's size is " + byteSize);
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

