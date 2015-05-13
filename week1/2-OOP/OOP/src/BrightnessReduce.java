public class BrightnessReduce implements MatrixOperation {
	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		Pixel pixel = matrix[x][y];
		Pixel newPixel = new Pixel(pixel.red / 2, pixel.green / 2,
				pixel.blue / 2);
		return newPixel;
	}
}