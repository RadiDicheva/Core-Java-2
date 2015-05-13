
class Node {
	private int data;
	public Node previous;
	public Node next;
	
	public Node(int data) {
		this.data = data;
		previous = null;
		next = null;
	}

	public Node(int data, Node previous, Node next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
		
	public int getData() {
		return data;
	}
}

public class DoublyLinkedList implements DoublyLinkedListInterface {
	private Node head;
	private int size;
	
	public DoublyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addHead(int data) {
		if(head == null) 
			head = new Node(data, null, null);
		else {
			Node newNode = new Node(data, null, head);
			head.previous = newNode;
			head = newNode;
		}
		
		size++;
	}
	
	public void addTail(int data) {
		if(head == null)
			head = new Node(data, null, null);
		else {
			Node current = head;
			
			while (current.next != null)
				current = current.next;
			
			Node newNode = new Node(data, current, null);
			current.next = newNode;
		}
		
		size++;
	}
	
	public void removeHead() {
		if(head == null) 
			return;
		
		head = head.next;
		head.previous = null;
		
		size--;
	}
	
	public void removeTail() {
		if(head == null)
			return;
		
		if(head.next == null) {
			head = null;
			size--;
			return;
		}
		
		Node current = head;
		
		while (current.next.next != null)
			current = current.next;
		
		current.next = null;
		size--;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int getHead() {
		if(head == null)
			return 0;
		else {
			Node current = head;
			
			while(current.previous != null)
				current = current.previous;
			
			return current.getData();
		}
	}
	
	public int getTail() {
		if(head == null)
			return 0;
		else {
			Node current = head;
			
			while(current.next != null)
				current = current.next;
		
			return current.getData();
		}
	}
	
	public int get(int elementIndex) {
		Node current = head;
		
		for (int i = 0; i < elementIndex; i++) {
			current = current.next;
		}
		
		return current.getData();
	}
	
	public void print() {
		Node current = head;
		
		while (current != null) {
			System.out.println(current.getData());
			current = current.next;
		}
	}
}