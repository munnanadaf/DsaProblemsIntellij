package stacks;

import java.util.Stack;

class ValidateStackSequence {
	public static void main(String[] args) {
		int pushed[] = { 1, 2, 3, 4, 5 };
		int popped[] = { 4, 5, 3, 2, 1 };
		System.out.println(validateStackSequences(pushed, popped));
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> st = new Stack<Integer>();
		int j = 0; // pop index.
		for (int p : pushed) {
			st.push(p);
			while (!st.isEmpty() && st.peek() == popped[j]) {
				st.pop();
				j++;
			}
		}
		return st.isEmpty();
	}
}