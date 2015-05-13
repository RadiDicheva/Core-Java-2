
public class DatabaseCorruptedException extends RuntimeException {
	public DatabaseCorruptedException() {
		super("This isn't a valid username! Don't be dumb!");
		printStackTrace();
	}
}
