package stacks;

import java.util.Stack;

public class Find132Pattern {
	public static boolean find132Pattern(int[] nums) {
		Stack<Integer> st = new Stack<>();
		// stack to store 32
		int n = nums.length;
		int second = Integer.MIN_VALUE;
		// Now, we are finding 1 as nums[i], stack will contain pattern 32 and we havee
		// to find nums[i] which is less then second so it will also less then st.peek()
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] < second) // found 1, 32 already present in stack.
				return true;
			while (!st.isEmpty() && st.peek() < nums[i])
				second = st.pop(); // monotonically decreasing stack.
			st.push(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 0, 1, -4, -3 };
		System.out.println(find132Pattern(nums));
	}

}
