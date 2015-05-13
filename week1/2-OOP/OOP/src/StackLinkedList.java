
public class StackLinkedList {
	DoublyLinkedList dll = new DoublyLinkedList();
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int number) {
		dll.addTail(number);
		size++;
	}

	public int pop() {
		int current = dll.getTail();
		dll.removeTail();
		size--;
		return current;
	}

	public int length() {
		return size;
	}

	public void clear() {
		while(!isEmpty()) {
			dll.removeTail();
			size--;
		}
	}

	public int peek() {
		return dll.getTail();
	}
}
