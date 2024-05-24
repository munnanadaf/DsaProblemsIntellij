package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MaximumSubSequenceScore {
	public long maxScore(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int[][] pairs = new int[n][2];
		for (int i = 0; i < n; i++) {
			pairs[i] = new int[] { nums1[i], nums2[i] };
		}

		Arrays.sort(pairs, (a, b) -> b[1] - a[1]); // sorting based on num2 elements, decreasing
		long ans = 0, sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // meanheap, only num1 elements.
		for (int i = 0; i < n; i++) {
			sum = sum + pairs[i][0];
			pq.offer(pairs[i][0]);
			if (pq.size() == k) {
				ans = Math.max(ans, sum * pairs[i][1]); // current i will have min nums2 element at k == pq.size
				sum = sum - pq.poll(); // last min element. removing from sum. min
			}
		}
		// for next iteration only 1st nums max elements & 2nd nums min element matters.
		return ans;
	}
}