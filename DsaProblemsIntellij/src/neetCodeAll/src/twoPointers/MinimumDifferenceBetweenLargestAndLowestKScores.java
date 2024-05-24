package twoPointers;

import java.util.Arrays;

class MinimumDifferenceBetweenLargestAndLowestKScores {
	public int minimumDifference(int[] nums, int k) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(nums);
		int n = nums.length;
		int l = 0, r = k - 1; // bcz 0 based index (given window = k)
		while (r < n) {
			int diff = nums[r] - nums[l];
			min = Math.min(min, diff);
			l++;
			r++;
		}
		return min;
	}
}