package slidingWindow;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubArrayWithAtmostKFrequency {
	public static int maxSubarrayLength(int[] nums, int k) {
		int max = 0;
		int left = 0;
		int n = nums.length;
		Map<Integer, Integer> freq = new HashMap<>();
		for (int right = 0; right < n; right++) {
			freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
			while (freq.get(nums[right]) > k) {
				freq.put(nums[left], freq.get(nums[left]) - 1); // moving window until curElement freq reduces by 1, we
																// might have max till now already.
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 3 };
		int k = 2;
		System.out.println(maxSubarrayLength(arr, k));

	}
}