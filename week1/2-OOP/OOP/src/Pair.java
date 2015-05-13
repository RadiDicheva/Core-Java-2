
public final class Pair {
	private final Object obj1;
	private final Object obj2;
	
	public Pair(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	private Object getObj1() {
		return obj1;
	}
	
	private Object getObj2() {
		return obj2;
	}

	@Override
	public final String toString() {
		return obj1 + " and " + obj2 + " are a pair of objects";
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getObj1().equals(((Pair) obj).getObj1()) && this.getObj2().equals(((Pair) obj).getObj2()))
			return true;
		else 
			return false;
	}	
}
