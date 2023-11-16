package edu.dvccomsci256jc;

public class AdvJava9 {

	public static void main (String [] args) {
		Complex[][] m1 = new Complex[][] {
		    {new Complex(1.0, 2.0), new Complex(2.0, 3.0), new Complex(3.0, 4.0), new Complex(4.0, 5.0)},
		    {new Complex(1.0, 6.0), new Complex(3.0, 9.0), new Complex(4.0, 9.0), new Complex(2.0, 10.0)}
		};

		Complex[][] m2 = new Complex[][] {
		    {new Complex(2.0, 3.0), new Complex(3.0, 4.0), new Complex(4.0, 5.0), new Complex(5.0, 6.0)},
		    {new Complex(6.0, 7.0), new Complex(9.0, 8.0), new Complex(9.0, 7.0), new Complex(10.0, 6.0)}
		};
		
		ComplexMatrix matrix = new ComplexMatrix();
		
		Complex [][] addedMatrix = matrix.addMatrix(m1, m2);
		Complex [][] multipliedMatrix = matrix.multiplyMatrix(transpose(m1), m2);
		System.out.println("\nm1 + m2 is ");
		ComplexMatrix.printResult(
				 m1, m2, addedMatrix, '+');
		System.out.println("\nm1 * m2 is ");
		ComplexMatrix.printResult(
			    m1, m2, multipliedMatrix, '*');

		
	}

	private static Complex[][] transpose(Complex[][] matrix) {
		    int rows = matrix.length;
		    int columns = matrix[0].length;
		    Complex[][] result = new Complex[columns][rows];
		    
		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < columns; j++) {
		            result[j][i] = matrix[i][j];
		        }
		    }
		    
		    return result;
		}
}