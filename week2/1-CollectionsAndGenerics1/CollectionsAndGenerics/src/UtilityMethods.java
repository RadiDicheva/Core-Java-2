import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UtilityMethods {

	public static <T> void rotate(Collection<T> collection, int rotateStep) {
		Deque<T> deque = new ArrayDeque<T>();
		deque.addAll(collection);

		if (rotateStep == 0)
			System.out.println(deque);
		else if (rotateStep > 0) {
			for (int i = 0; i < rotateStep; i++) {
				T temp = deque.removeLast();
				deque.addFirst(temp);
			}
		} else {
			for (int i = rotateStep; i < 0; i++) {
				T temp = deque.removeFirst();
				deque.addLast(temp);
			}
		}

		System.out.println(deque);
	}
	
	public static <T> Object uniqueElement(Collection<T> collection) {
		ArrayList<T> list = new ArrayList<T>();
		ArrayList<T> result = new ArrayList<T>();
		list.addAll(collection);
		
		for (int i = 0; i < list.size(); i++) {
			if(result.contains(list.get(i)))
				result.remove(list.get(i));
			else
				result.add(list.get(i));
		}
		
		if (!result.isEmpty())
			return result.get(0);
		else 
			return null;
	}
	
	public static <T> HashSet<T> setDuplicatingElement (Collection<T>... collections) {
		HashSet<T> hs = new HashSet<T>();
		
		for (Collection<T> coll : collections)
			hs.addAll(coll);
		
		for (Collection<T> coll : collections)
			hs.retainAll(coll);
			
		return hs;
	}

	public static String humanHashMap(
			HashMap<? extends Object, ? extends Object> inputHashMap) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (Entry<? extends Object, ? extends Object> element : inputHashMap
				.entrySet()) {
			sb.append(element.getKey() + ":" + element.getValue() + ", ");
		}
		sb.delete(sb.length() - 2, sb.length() - 1);
		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Integer> countWords(String text) {
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		String[] words = text.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (!result.containsKey(words[i]))
				result.put(words[i], 1);
			else
				result.put(words[i], result.get(words[i]) + 1);
		}

		return result;
	}

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		rotate(collection, 0);
		rotate(collection, 1);
		rotate(collection, -1);
		
		Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1);
		System.out.println(uniqueElement(ints));
		
		Collection<Integer> coll1 = new ArrayList<Integer>();
		Collection<Integer> coll2 = new ArrayList<Integer>();
		Collection<Integer> coll3 = new ArrayList<Integer>();
		coll1.add(1);
		coll1.add(2);
		coll1.add(3);
		coll1.add(4);
		coll1.add(5);
		coll2.add(4);
		coll2.add(5);
		coll2.add(6);
		coll3.add(5);
		coll3.add(6);
		coll3.add(7);
		coll3.add(8);
		System.out.println(setDuplicatingElement(coll1, coll2, coll3));

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "losho");
		hm.put(2, "mi");
		hm.put(3, "e");

		System.out.println(humanHashMap(hm));

		System.out
				.println(countWords("Ninjas are all over the place! We are all going to die!"));
	}
}
