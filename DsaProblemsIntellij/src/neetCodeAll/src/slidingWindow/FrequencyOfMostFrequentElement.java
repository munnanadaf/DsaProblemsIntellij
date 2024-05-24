package slidingWindow;

import java.util.Arrays;

class FrequencyOfMostFrequentElement {
	public int maxFrequency(int[] nums, int k) {
		int n = nums.length;
		Arrays.sort(nums);
		long sum = 0;
		int ans = 1; // res numbers which can be made same.
		int l = 0, r = 0;
		while (r < n) {
			sum = sum + nums[r];
			while ((nums[r] * 1L * (r - l + 1)) - sum > k) { // checking for valid window
				sum = sum - nums[l];
				l = l + 1;
			}
			ans = Math.max(ans, r - l + 1);
			r++;
		}
		return ans;
	}
}