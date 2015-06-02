public class WorkerThread extends Thread {
	private int row;
	private int column;
	private int[][] matrixA;
	private int[][] matrixB;
	private int[][] matrixProduct;

	public WorkerThread(int row, int column, int[][] matrixA, int[][] matrixB,
			int[][] matrixProduct) {
		this.row = row;
		this.column = column;
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixProduct = matrixProduct;
	}

	public void run() {
		matrixProduct[row][column] = (matrixA[row][0] * matrixB[0][column])
				+ (matrixA[row][1] * matrixB[1][column]);
	}
}
