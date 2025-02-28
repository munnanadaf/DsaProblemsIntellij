package hashing;

import java.util.Arrays;

class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int max = 1;
		int count = 1;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				continue;
			if ((nums[i] + 1) == nums[i + 1]) {
				count++;
				max = Math.max(count, max);
			} else {
				count = 1;
			}
		}
		
		return max;
	}
}