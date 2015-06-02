public class Poll extends Thread {
	final private BlockingQueue block;

	public Poll(BlockingQueue block) {
		this.block = block;
	}

	public void run() {
		try {
			block.poll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
