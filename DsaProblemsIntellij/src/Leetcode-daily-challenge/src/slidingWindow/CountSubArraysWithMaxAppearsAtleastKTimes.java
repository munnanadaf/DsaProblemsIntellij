package slidingWindow;

import java.util.Arrays;

class CountSubArraysWithMaxAppearsAtleastKTimes {
	public long countSubarrays(int[] nums, int k) {
		int max = Arrays.stream(nums).max().getAsInt();
		int n = nums.length, cur = 0, i = 0;
		long res = 0;
		for (int j = 0; j < n; j++) {
			cur = cur + (nums[j] == max ? 1 : 0);
			while (cur >= k) {
				cur = cur - (nums[i++] == max ? 1 : 0);
			}
			res = res + i; // each left element is part of subarray, remember, left moved only when we
							// encountered subarray with freq>=k
		}
		return res;
	}
}