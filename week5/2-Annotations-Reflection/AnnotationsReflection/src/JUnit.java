import java.util.Arrays;

public class JUnit {
	public static void assertTrue(boolean condition) {
		if (!condition)
			throw new AssertionError("False condition!");
	}

	public static void assertFalse(boolean condition) {
		if (condition)
			throw new AssertionError("True condition!");
	}

	public static void fail() {
		throw new AssertionError("Test failed!");
	}

	public static void assertEquals(Object expected, Object actual) {
		if (!expected.equals(actual))
			throw new AssertionError("Expected is not equal to actual!");
	}
	
	public static void assertNotEquals(Object unexpected, Object actual) {
		if (unexpected.equals(actual))
			throw new AssertionError("Unexpected is equal to actual!");
	}
	
	public static void assertArrayEquals(Object[] expected, Object[] actual) {
		if (!Arrays.equals(expected, actual))
			throw new AssertionError("Expected array is not equal to actual array!");
	}
	
	public static void assertNotNull(Object object) {
		if (object == null)
			throw new AssertionError("The object is null!");
	}
	
	public static void assertNull(Object object) {
		if (object != null)
			throw new AssertionError("The object is not null!");
	}
	
	public static void assertSame(Object expected, Object actual) {
		if (expected != actual)
			throw new AssertionError("Expected is not the same as actual!");
	}
	
	public static void assertNotSame(Object unexpected, Object actual) {
		if (unexpected == actual)
			throw new AssertionError("Unexpected is the same as actual!");
	}
	
	public static void main(String [] args) {
		Object a = 4;
		Object b = 3.5;
		assertNotNull(b);
		assertNotSame(a, b);
	}
}
