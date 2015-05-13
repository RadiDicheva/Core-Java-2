import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the username: ");
		String username = input.nextLine();
		if (username.equals("")) 
			throw new DatabaseCorruptedException();
		input.close();
		
		try {
			CheckedException ex = new CheckedException(false, false, true);
			ex.useService();
		} catch (ServiceNotAvailableAtTheMoment e) {
			System.out.println(e);
		}
		
		Time time = new Time(14, 3, 25, 24, 2, 2015);
		System.out.println(time.toString());
		
		Time curTime = new Time();
		System.out.println(curTime.now());
		
		NoNullKeys nnk = new NoNullKeys();
		nnk.put(1, "I");
		nnk.put(2, "you");
		nnk.put(3, "he");
		nnk.put(4, "she");
		System.out.println(nnk.toString());
		//System.out.println(nnk.get(8));
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			arrList.add(i);

		ImmutableList<Integer> il = new ImmutableList<Integer>(arrList);
		System.out.println(il.get(3));
		// il.add(11);
		// il.remove();
		// il.clear();

		int[] array = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		ImmutableList.asList(array);
	}
}
