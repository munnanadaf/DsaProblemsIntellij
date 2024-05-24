package randomProblems;

import java.util.Stack;

public class ValidParentheis {
	public static void main(String[] args) {
		String s = "(())";
//		System.out.println(isValidParenthesis(s));
		System.out.println(isValid(s));
	}

	private static boolean isValidParenthesis(String s) {
		Stack<Character> st = new Stack<>();
//		for odd length
		if (s.length() % 2 != 0)
			return false;
//		for empty string
		if (s.length() == 0)
			return true;
//		if string starts with ending parenthesis
		if (s.startsWith("}") || s.startsWith("]") || s.startsWith(")"))
			return false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				st.push(c);
			} else {

//				if we encounter only ending parenthesis and the stack is already empty means, invalid, bcz opening braces are misssing
				if (st.isEmpty() && i != s.length() - 1) {
					return false;
				} else {
					if ((c == '}' && st.pop() == '{') || (c == ']' && st.pop() == '[')
							|| (c == ')' && st.pop() == '(')) {

					}

					else {
						return false;
					}
				}
			}
		}

		if (st.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		for (char a : s.toCharArray()) {
//          ( , ) , [, ] , { ,} are continuous ascii values using that property
			// Check if stack not empty and the top element corresponds to curr char
			if (!st.isEmpty() && (st.peek() == a - 1 || st.peek() == a - 2))
				st.pop();
			// else these migh be starting brackets or unsatisfied closing brackets
			else
				st.push(a);
		}

		return st.isEmpty();
	}

}
