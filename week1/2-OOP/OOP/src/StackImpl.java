import java.util.HashSet;

public class StackImpl implements Stack {
	private Object[] array;
	private int number;
	private HashSet<Object> noDuplicates = new HashSet<Object>();

	StackImpl(int maxNumber) {
		this.array = new Object[maxNumber];
		this.number = 0;
	}

	@Override
	public boolean isEmpty() {
		return (number == 0);
	}

	@Override
	public void push(Object obj) {
		if (!noDuplicates.contains(obj)) {
			noDuplicates.add(obj);
			array[number++] = obj;
		}
	}

	@Override
	public Object pop() {
		noDuplicates.remove(array[number-1]);
		Object object = array[number-1];
		array[--number] = null;
		return object;
	}

	@Override
	public int length() {
		int counter = 0;
		for (Object object : array) {
			if (object != null)
				counter++;
		}
		return counter;
	}

	@Override
	public void clear() {
		while (!isEmpty())
			pop();
	}

	@Override
	public Object peek() {
		if(number == 0)
			return null;
		return array[number - 1];
	}
}
