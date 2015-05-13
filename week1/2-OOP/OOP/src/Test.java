public class Test extends Calculator{

	public static void main(String[] args) {
		Audi audi = new Audi(100000, 682015101);
		audi.getMileage();
		System.out.println(audi.toString());
		
		Time time = new Time(14, 3, 25, 1, 4, 2015);
		System.out.println(time.toString());		
		Time curTime = new Time();
		System.out.println(curTime.now());
		
		Pair a = new Pair(1,2);
		Pair b = new Pair(1,3);
		System.out.println(a.toString());
		System.out.println(a.equals(b));
		
		StackImpl st = new StackImpl(5);
		st.push("maika");
		st.push("maika");
		st.push('c');
		System.out.println(st.length());
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.peek());
		st.clear();
		System.out.println(st.length());
		System.out.println(st.peek());
		
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addHead(10);
		dll.addHead(0);
		dll.addTail(20);
		dll.addTail(30);
		dll.print();
		System.out.println();
		dll.removeHead();
		dll.removeTail();
		dll.print();
		System.out.println();
		System.out.println(dll.getHead());
		System.out.println(dll.getTail());
		System.out.println(dll.get(0));
		
		StackLinkedList sll = new StackLinkedList();
		sll.push(1);
		sll.push(2);
		sll.push(3);
		sll.push(4);
		System.out.println(sll.length());
		System.out.println(sll.pop());
		System.out.println(sll.pop());
	}
}
