class Grayscale implements MatrixOperation {
	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		float red = matrix[x][y].getRed();
		float green = matrix[x][y].getGreen();
		float blue = matrix[x][y].getBlue();

		matrix[x][y] = new Pixel(
				(float) (red * 0.21 + green * 0.72 + blue * 0.07), (float) (red
						* 0.21 + green * 0.72 + blue * 0.07), (float) (red
						* 0.21 + green * 0.72 + blue * 0.07));
		return matrix[x][y];
	}
}