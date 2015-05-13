import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StatisticsImpl implements Statistics {
	private ArrayList<Integer> arrList = new ArrayList<Integer>();
	private double mean;
	private double median;
	private int range;
	private Set<Integer> mode = new HashSet<Integer>();
	
	@Override
	public void add(int number) {
		arrList.add(number);
		
		mean = 0;
		for (int i = 0; i < arrList.size(); i++)
			mean += arrList.get(i);
		mean /= arrList.size();
		
		if (arrList.size() % 2 != 0) 
			median = arrList.get(arrList.size()/2);
		else 
			median = ((double)arrList.get(arrList.size()/2) + (double)arrList.get((arrList.size()-1)/2))/2;
		
		Collections.sort(arrList);
		range = arrList.get(arrList.size()-1) - arrList.get(0);
		
		Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i = 0; i < arrList.size(); i++) {
			if (!hm.containsKey(arrList.get(i)))
				hm.put(arrList.get(i), 1);
			else
				hm.put(arrList.get(i), hm.get(arrList.get(i))+1);
			if (hm.get(arrList.get(i)) > max) {
                max = hm.get(arrList.get(i));
                mode.clear();
                mode.add(arrList.get(i));
            } else if (hm.get(arrList.get(i)) == max)
                mode.add(arrList.get(i));
		}
	}
	
	public int size() {
		return this.arrList.size();
	}

	@Override
	public double getMean() {
		return mean;
	}

	@Override
	public double getMedian() {
		return median;
	}

	@Override
	public Set<Integer> getMode() {
		return mode;
	}

	@Override
	public int getRange() {
		return range;
	}

	public static void main(String[] args) {
		StatisticsImpl stat = new StatisticsImpl();
		stat.add(1);
		stat.add(1);
		stat.add(2);
		stat.add(2);
		stat.add(2);
		stat.add(3);
		
		System.out.println(stat.getMean());
		System.out.println(stat.getMedian());
		System.out.println(stat.getRange());
		System.out.println(stat.getMode());
	}
}
