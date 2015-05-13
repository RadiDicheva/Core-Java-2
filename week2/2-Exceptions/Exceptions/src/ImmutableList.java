import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ImmutableException extends RuntimeException {
	public ImmutableException() {
		super("You are trying to change an immutable list!");
		printStackTrace();
	}
}

public class ImmutableList<E> extends ArrayList<E> implements List<E> {
	private ArrayList<E> imList = new ArrayList<E>();

	public ImmutableList(Collection<? extends E> collection) {
		if (imList.isEmpty())
			imList.addAll(collection);
		else
			throw new ImmutableException();
	}

	public boolean add(E item) {
		if (imList.isEmpty()) {
			imList.add(item);
			return true;
		} else
			throw new ImmutableException();
	}

	public void remove() {
		if (!imList.isEmpty())
			throw new ImmutableException();
	}

	public void clear() {
		if (!imList.isEmpty())
			throw new ImmutableException();
	}
	
	public E get(int index) {
		imList.clone();
		return imList.get(index);
	}

	@SafeVarargs
	public static <T> List<T> asList(T... arguments) {
		ArrayList<T> array = new ArrayList<T>();
		for (T item : arguments) {
			array.add(item);
		}
		return array;
	}
}
