public class Add extends Thread {
	final private BlockingQueue block;
	
	public Add(BlockingQueue block) {
		this.block = block;
	}

	public void run() {
		try {
			block.add();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
