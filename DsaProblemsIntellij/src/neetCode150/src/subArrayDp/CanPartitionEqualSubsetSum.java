package subArrayDp;

class CanPartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		int n = nums.length;

		for (int i : nums)
			sum += i;

		if (sum % 2 != 0)
			return false;

		sum /= 2;

		Boolean mem[][] = new Boolean[n + 1][sum + 1];

		return subsetSum(nums, mem, 0, sum);
	}

	boolean subsetSum(int[] nums, Boolean mem[][], int pos, int sum) {
		if (sum == 0)
			return true;

		else if (pos >= nums.length || sum < 0)
			return false;

		if (mem[pos][sum] != null)
			return mem[pos][sum];

		return mem[pos][sum] = subsetSum(nums, mem, pos + 1, sum - nums[pos]) || subsetSum(nums, mem, pos + 1, sum);
	}
}