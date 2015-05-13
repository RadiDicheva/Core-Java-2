import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
	private String name;
	private int priority;
	private int timeRequired;

	public Task(String name, int priority, int timeRequired) {
		this.name = name;
		this.priority = priority;
		this.timeRequired = timeRequired;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}
	
	@Override
	public String toString() {
		return "Task: " + getName() + ", priority: " + getPriority() + ", required time: " + getTimeRequired();
	}
}

public class ToDoList {

	private int remainingTime;
	
	private PriorityQueue<Task> priorityQueue = new PriorityQueue<Task>(10, new Comparator<Task>() {
		@Override
		public int compare(Task task1, Task task2) {
			if (task1.getPriority() < task2.getPriority())
				return 1;
			else if (task1.getPriority() > task2.getPriority())
				return -1;
			else 
				return 0;
		}
	});

	public ToDoList(int timeRemaining) {
		this.remainingTime = timeRemaining;
	}
	
	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int timeRemaining) {
		this.remainingTime = timeRemaining;
	}

	void add(Task t) {
		if (getRemainingTime() > t.getTimeRequired()) {
			priorityQueue.offer(t);
			setRemainingTime(getRemainingTime() - t.getTimeRequired());
		} else {
			System.out.println("I am...screwed");
		}
	}

	void markFinished(Task t) {
		if(priorityQueue.peek().equals(t)) {
			priorityQueue.poll();
			System.out.println("Task is finished");
		} else
			System.out.println("No such task in your list");
	}

	void markCancelled(Task t) {
		if (priorityQueue.contains(t)) {
			priorityQueue.remove(t);
			System.out.println("Task is cancelled");
			setRemainingTime(getRemainingTime() + t.getTimeRequired());
		} else 
			System.out.println("No such task in your list");
	}

	Task getTop() {
		return priorityQueue.peek();
	}

	boolean canFinish() {
		return getRemainingTime() >= 0;
	}

	public static void main(String[] args) {
		Task t = new Task("Eat", 5, 3);
		Task t2 = new Task("Drink coffee", 8, 1);
		Task t3 = new Task("Study", 1, 4);
		ToDoList todo = new ToDoList(7);
		todo.add(t);
		todo.add(t2);
		todo.add(t3);
		todo.markCancelled(t);
		System.out.println(todo.getRemainingTime());
		System.out.println(todo.getTop());
		System.out.println(todo.canFinish());
	}
}
