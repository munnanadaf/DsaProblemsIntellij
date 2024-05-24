package subArrayDp;

class MaxProductSubArray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int curMin = nums[0], curMax = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tmp = curMax;
			curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
			curMin = Math.min(Math.min(tmp * nums[i], curMin * nums[i]), nums[i]);
			result = Math.max(curMax, result);
		}
		return result;
	}
}