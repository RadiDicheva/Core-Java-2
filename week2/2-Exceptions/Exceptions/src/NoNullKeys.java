import java.util.HashMap;

class NoNulls extends RuntimeException {
	public NoNulls(String message) {
		super(message);	
		printStackTrace();
	}
}

public class NoNullKeys extends HashMap {
	private boolean flag = true;
	private HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
	
	@Override
	public Object put (Object keys, Object values) {
		if (keys != null && values != null)
			hashMap.put(keys, values);
		else if (keys == null && values != null){
			flag = false;
			throw new NoNulls("You are trying to insert null key!");
		} else if (keys != null && values == null){
			flag = false;
			throw new NoNulls("You are trying to insert null value!");
		} else {
			flag = false;
			throw new NoNulls("You are trying to insert null key and value!");
		}
		return values;
	}
	
	public Object get(Object keys) {
		if (hashMap.containsKey(keys))
			return hashMap.get(keys);
		else 
			throw new NoNulls("You are trying to get a null key value!");
	}

	@Override
	public String toString() {
		return hashMap.toString();
	}
}
