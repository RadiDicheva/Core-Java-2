import java.util.Set;

public interface Statistics {
	double getMean();
	double getMedian();
	Set<Integer> getMode();
	int getRange();
	void add(int number);
}
