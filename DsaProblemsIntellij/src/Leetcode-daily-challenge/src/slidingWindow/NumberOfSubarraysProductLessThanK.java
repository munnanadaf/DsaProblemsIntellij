package slidingWindow;

class NumberOfSubarraysProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1)
			return 0;
		int n = nums.length;
		int prod = 1, res = 0, left = 0;
		for (int right = 0; right < n; right++) {
			prod = prod * nums[right];
			while (prod >= k) {
				prod = prod / nums[left];
				left++;
			}
			res = res + right - left + 1;
		}
		return res;
	}
}