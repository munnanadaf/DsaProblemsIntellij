package stacks;

import java.util.Stack;

class RemovingStarsFromString {
	public String removeStars(String s) {
		Stack<Character> st = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '*') {
				if (!st.isEmpty())
					st.pop();
				else {

				}
			} else {
				st.push(c);
			}

		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
	}
}