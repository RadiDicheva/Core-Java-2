import java.util.ArrayList;
import java.util.Collection;

public class ReverseCollection {
	
	public static <T> void reverse(Collection<T> collection) {
		T[] array = (T[]) collection.toArray();	
		int i = 0, j = array.length - 1;
		
		while (i <= j) {
			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			j--;
			i++;
		}
		
		System.out.println(collection);
		collection.clear();
		
		for (int k = 0; k < array.length; k++) 
			collection.add(array[k]);
		
		System.out.println(collection);
	}

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		
		reverse(collection);
	}
}
