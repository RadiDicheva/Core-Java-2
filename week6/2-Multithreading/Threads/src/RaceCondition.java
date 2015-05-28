import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {

	public static void main(String[] args) {
		long start = System.nanoTime();
	
		Runnable run = new RunnableClass();
		Thread A = new Thread(run);
		Thread B = new Thread(run);
		A.start();
		B.start();

		try {
			A.join();
			B.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		RunnableClass result = new RunnableClass();
		//System.out.println(result.increment());
		//System.out.println(result.getCounter());
		System.out.println(result.getCounterAtomic());
		
		
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);
	}
}

class RunnableClass implements Runnable {
	private static int counter = 0;
	private static AtomicInteger counterAtomic = new AtomicInteger();

	public synchronized void increment() {
		for (int i = 0; i < 2_000_000; i++)
			counter++;
	}
	
	/*@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 2_000_000; i++)
				counter++;
		}
	}*/
	
	@Override
	public void run() {
		for (int i = 0; i < 2_000_000; i++)
			counterAtomic.incrementAndGet();
	}

	public int getCounter() {
		return counter;
	}
	
	public AtomicInteger getCounterAtomic() {
		return counterAtomic;
	}
}
