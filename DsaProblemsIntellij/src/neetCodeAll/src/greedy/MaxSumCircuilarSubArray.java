package greedy;

class MaxSumCircuilarSubArray {
	public int maxSubarraySumCircular(int[] nums) {
		int nonCir = kadaneAlgo(nums);
		// circuilar sum = total-minsum;
		// for minsum we will multiply by -1 to each element;
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			nums[i] = nums[i] * (-1);
		}
		int minSum = kadaneAlgo(nums);
		int cirSum = sum + minSum;
		if (cirSum == 0)
			return nonCir;
		else
			return Math.max(nonCir, cirSum);
	}

	public int kadaneAlgo(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for (int num : nums) {
			curSum = curSum + num;
			maxSum = Math.max(curSum, maxSum);
			if (curSum < 0) {
				curSum = 0;
			}
		}
		return maxSum;
	}
}