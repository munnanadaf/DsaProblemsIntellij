package stacks;

import java.util.Stack;

class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0)
			return temperatures;
		int n = temperatures.length;
		Stack<Integer> st = new Stack<>();
		int ans[] = new int[n];
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
				ans[st.peek()] = i - st.pop();
			}
			st.push(i);
		}
		return ans;
	}
}