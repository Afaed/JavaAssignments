package edu.dvccomsci256jc;


public class LabExercise9 {
	
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		
		int length = list.length - 1, start = 0;
		
		while(start <= length) {
			int middle = (length + start) /2;
			
			if(list[middle].equals(key)) {
				return (int) middle;
			}
			
			if(list[middle].compareTo(key) < 0) {
				start = middle + 1;
			} else {
				length = middle - 1;
			}
			
		}
		
		return -length - 2;
	}
	
	public static void main (String [] args) {
		Integer [] intArray = {-12, -4, 0, 5, 6, 19, 119, 200};
		String [] stringArray = {"a", "book", "desk", "table"};
		
		System.out.println(
				"200 is located at the index of " + binarySearch(intArray, Integer.valueOf(200)) + "\n" +
				"-1 is located at the index of " + binarySearch(intArray, -1) + "\n" + 
				"\"desk\" is located at index of " + binarySearch(stringArray, "desk") + "\n" +
				"\"lamp\" is located at the index of " + binarySearch(stringArray, "lamp") + "\n"
				);
		
	}
}
