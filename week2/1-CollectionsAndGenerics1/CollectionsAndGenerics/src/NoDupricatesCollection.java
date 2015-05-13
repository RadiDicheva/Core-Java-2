import java.util.ArrayList;
import java.util.Collection;

public class NoDupricatesCollection<T> {
	private Collection<T> collection;
	
	public NoDupricatesCollection(Collection<T> coll) {
		this.collection = coll;
	}

	public void add (T obj) {
		if (obj == null)
			throw new IllegalArgumentException("Adding null");
		else {
			if (collection.contains(obj))
				collection.remove(obj);
			else 
				collection.add(obj);
		}
	}
	
	@Override
	public String toString() {
		return collection.toString();
	}

	public static void main(String[] args) {
		Collection<Integer> list = new ArrayList<Integer>();
		NoDupricatesCollection<Integer> coll = new NoDupricatesCollection<Integer>(list);
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(2);
        System.out.println(coll.toString());
	}
}