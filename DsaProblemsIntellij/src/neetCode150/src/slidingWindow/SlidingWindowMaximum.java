package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int res[] = new int[n - k + 1];
		int r = 0;
		// storing indexes in queue
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			// out of window elements index removing
			while (!dq.isEmpty() && dq.peek() == (i - k)) {
				dq.poll();
			}
//removing smaller elements from que tail
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}

			dq.offer(i);

// once we have enough window size elements. since 0 based index -1 we are doing
			if (i >= k - 1) {
				res[r++] = nums[dq.peek()];
			}

		}
		return res;
	}
}