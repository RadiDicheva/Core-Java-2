import java.util.Random;

public class MultiplyMatrices {
	public static int maxRows = 3;
	public static int maxColumns = 3;

	public static int[][] matrixA = new int [3][2]; //{ { 1, 2 }, { 3, 4 }, { 5, 0 } };
	public static int[][] matrixB = new int [2][3]; //{ { 1, 0, 0 }, { 0, 1, 0 } };
	public static int[][] matrixProduct = new int[maxRows][maxColumns];
	public static WorkerThread[][] thread = new WorkerThread[maxRows][maxColumns];
	
	private static void fillMatrix(int[][] matrix) {
		Random random = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = random.nextInt(100) + 1;
		}
	}

	public static void main(String[] args) {
		fillMatrix(matrixA);
		fillMatrix(matrixB);
		
		for (int i = 0; i < maxRows; i++) {
			for (int j = 0; j < maxColumns; j++) {
				thread[i][j] = new WorkerThread(i, j, matrixA, matrixB,
						matrixProduct);
				thread[i][j].start();
			}
		}

		System.out.println("Product matrix is: ");
		for (int i = 0; i < maxRows; i++) {
			for (int j = 0; j < maxColumns; j++) {
				System.out.println("[" + i + "," + j + "] = "
						+ matrixProduct[i][j]);
			}
		}
	}
}
