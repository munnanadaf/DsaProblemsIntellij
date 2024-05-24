package permutation;

class SumOfAllSubsetXORTotals {
	public int subsetXORSum(int[] nums) {
		return helper(nums, 0, 0);
	}

	public int helper(int[] nums, int ind, int curXor) {
		if (ind == nums.length)
			return curXor;
		int withCurInd = helper(nums, ind + 1, curXor ^ nums[ind]);
		int withoutCurInd = helper(nums, ind + 1, curXor);
		return withCurInd + withoutCurInd; // as we need to return all subset xor sum;
	}
}