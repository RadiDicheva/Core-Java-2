import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	Lock kliuchalka = new Lock();
	public Queue<Integer> queue = new LinkedList<Integer>();
	
	public synchronized void add() throws InterruptedException {
		kliuchalka.lock();
		
		System.out.println("Element added!");
		for (int i = 0; i < 100; i++) {
			queue.add(i);
			notifyAll();
		}
		
		kliuchalka.unlock();
	}
	
	public synchronized void poll() throws InterruptedException {
		kliuchalka.lock();
		
		if(!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				queue.poll();
				System.out.println("Element polled!");
			}
		} else {
			wait();
		}
		
		kliuchalka.unlock();	
	}
	
	public static void main(String[] args) {
		BlockingQueue block = new BlockingQueue();
		
		Thread threadOne = new Add(block);
		Thread threadTwo = new Poll(block);
		threadOne.start();
		threadOne.setPriority(8);
		threadTwo.start();
	}
}