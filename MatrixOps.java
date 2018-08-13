public class MatrixOps
{
	public static double[][] multiply(double[][] A, double[][] B)
	{

		int rowA = A.length;
		int rowB = B.length;
		int columnA = A[0].length;
		int columnB = B[0].length;


		double[][] matrix3 = new double[A.length][B[0].length];
		

		if ( columnA != rowB ) {
		    System.out.println("Matrix does not match cannot be multiplied");
		    return null;
		  }

		for(int i = 0; i < rowA; i++){
			for(int j = 0; j < columnB; j++){
				for(int k = 0; k < columnA; k++){
					matrix3[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		return matrix3;
	}
}
