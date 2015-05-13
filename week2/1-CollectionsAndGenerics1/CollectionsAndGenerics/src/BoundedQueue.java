import java.util.LinkedList;
import java.util.Queue;

public class BoundedQueue<T> implements QueueInterface{
	private Queue<T> queue = new LinkedList<T>();
	private int size;
	private int bound;
	
	public BoundedQueue(int bound) {
		this.size = 0;
		this.bound = bound;
	}

	@Override
	public void offer(Object obj) {
		if(size < bound) {
			queue.add((T) obj);
			size++;
		} else {
			queue.remove();
			queue.add((T) obj);
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		return queue.toString();
	}
	
	public static void main(String[] args) {
		BoundedQueue<Integer> q = new BoundedQueue<Integer>(3);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		System.out.println(q.toString());		
	}
}
