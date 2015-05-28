import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PointCalculations {

	public static List<Point> generatePoints() {
		List<Point> listPoint = new ArrayList<Point>();

		Random rand = new Random();
		int low = 0;
		int high = 10_001;

		for (int i = 0; i < 100_000; i++) {
			int x = rand.nextInt(high - low) + low;
			int y = rand.nextInt(high - low) + low;
			Point point = new Point(x, y);
			listPoint.add(point);
		}

		return listPoint;
	}

	/*public static Map<Point, Point> getNearestPoints(List<Point> generatedPoints) {
		Map<Point, Point> mapPoint = new HashMap<Point, Point>();

		for (int i = 0; i < generatedPoints.size(); i++) {
			int min = 10_001;
			for (int j = 0; j < generatedPoints.size(); j++) {
				if (i != j) {
					if (min > generatedPoints.get(i).distance(
							generatedPoints.get(j))) {
						min = generatedPoints.get(i).distance(
								generatedPoints.get(j));
						mapPoint.put(generatedPoints.get(i),
								generatedPoints.get(j));
					}
				}
			}
		}

		return mapPoint;
	}*/
	
	public static Map<Point, Point> getNearestPoints(final List<Point> generatedPoints) {
		final Map<Point, Point> mapPoint = new HashMap<Point, Point>();
		
		Runnable threadOne = new Thread () {
			@Override
			public void run() {
				synchronized (this) {
					doCalculations(generatedPoints, 0, generatedPoints.size()/2, mapPoint);
				}
			}
		};
		
		Runnable threadTwo = new Thread () {
			@Override
			public void run() {
				synchronized (this) {
					doCalculations(generatedPoints, generatedPoints.size()/2 + 1, generatedPoints.size(), mapPoint);
				}
			}
		};
		
		threadOne.run();
		threadTwo.run();
		
		return mapPoint;
	}

	public static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {
		for (int i = indexFrom; i < indexTo; i++) {
			int min = 10_001;
			for (int j = 0; j < inPoints.size(); j++) {
				if (i != j && min > inPoints.get(i).distance(inPoints.get(j))) {
					min = inPoints.get(i).distance(inPoints.get(j));
					outMap.put(inPoints.get(i), inPoints.get(j));
				}
			}
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		getNearestPoints(generatePoints());
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println(elapsedTime);
	}
}
