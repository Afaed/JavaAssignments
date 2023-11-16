package edu.dvccomsci256jc;

public class ComplexMatrix extends GenericMatrix<Complex> {

    @Override
    protected Complex add(Complex o1, Complex o2) {
        return o1.add(o2);
    }

    @Override
    protected Complex multiply(Complex o1, Complex o2) {
        return o1.multiply(o2);
    }

    @Override
    protected Complex zero() {
        return new Complex(0, 0);
    }

    public Complex[][] addMatrix(Complex[][] matrix1, Complex[][] matrix2) {
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException("The matrices do not have the same size");
        }

        Complex[][] result = new Complex[matrix1.length][matrix1[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    public Complex[][] multiplyMatrix(Complex[][] matrix1, Complex[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The matrices do not have compatible size");
        }

        Complex[][] result = new Complex[matrix1.length][matrix2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }

        return result;
    }

    public static void printResult(Complex[][] o1, Complex[][] o2, Complex[][] o3, char op) {
        int rows = o1.length;
        int columns = o1[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%5s", o1[i][j]);
            }

            if (i == rows / 2) {
                System.out.print("  " + op + "  ");
            } else {
                System.out.print("     ");
            }

            for (int j = 0; j < columns; j++) {
                System.out.printf("%5s", o2[i][j]);
            }

            if (i == rows / 2) {
                System.out.print("  =  ");
            } else {
                System.out.print("     ");
            }

            for (int j = 0; j < columns; j++) {
                System.out.printf("%5s", o3[i][j]);
            }

            System.out.println();
        }
    }
}
