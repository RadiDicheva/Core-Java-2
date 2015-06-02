public class Lock {
	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked == true)
			wait();

		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notifyAll();
	}
}
