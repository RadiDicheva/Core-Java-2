import java.util.Stack;

public class BracketsExpression {
	
	public static boolean isValidBracketExpression (String input) {
		char [] array = input.toCharArray();	
		Stack<Character> bracket = new Stack<Character>();
		
		if (array[0] != '(' || array[array.length-1] != ')')
			return false;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] == '(')
				bracket.push('(');
			else if (array[i] == ')') {
				if (!bracket.isEmpty())
					bracket.pop();
				else 
					return false;
			}		
		}
		
		return bracket.isEmpty();
	}

	public static void main(String[] args) {
		String input = "())()";
		System.out.println(isValidBracketExpression(input));
	}
}
