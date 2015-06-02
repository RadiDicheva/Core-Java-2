public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int distance(Point point) {
		int result = (int) Math.sqrt((this.x - point.x)*(this.x - point.x) + (this.y - point.y)*(this.y - point.y));
		return result;
	}

	@Override
	public String toString() {
		return "[x=" + x + " , y=" + y + "]";
	}
}
