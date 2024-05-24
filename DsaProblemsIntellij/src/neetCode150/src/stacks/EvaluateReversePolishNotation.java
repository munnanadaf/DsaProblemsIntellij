package stacks;

import java.util.Stack;

class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<>();
		int res = 0;
		for (String s : tokens) {

			if (!(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))) {
				st.push(Integer.valueOf(s));
			} else {
				if (st.size() > 1) {
					int a = st.pop();
					int b = st.pop();
					res = operate(a, b, s);
					st.push(res);
				}
			}
		}
		if (!st.isEmpty())
			return st.pop();
		return res;
	}

	public int operate(int b, int a, String c) {
		switch (c) {
		case "+":
			return a + b;

		case "-":
			return a - b;

		case "*":
			return a * b;

		case "/":
			return a / b;

		default:
			return 0;
		}
	}
}