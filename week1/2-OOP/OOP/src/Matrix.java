public class Matrix {
	int x, y;
	static Pixel[][] pixel;

	public Matrix(int x, int y, Pixel[][] pixel) {
		this.x = x;
		this.y = y;
		this.pixel = pixel;
	}

	public void filler() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++)
				pixel[i][j] = new Pixel(255 - i, 255 - j, 255 - (i + j));
		}
	}

	public Pixel[][] operate(MatrixOperation op) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++)
				pixel[i][j] = op.withPixel(i, j, pixel);
		}
		
		return pixel;
	}
}