package arrays;

// **** most asked, revise after few days
class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return -1;
		int leftSum = 0, rightSum = 0;
		for (int num : nums)
			rightSum += num;
		for (int i = 0; i < n; i++) {
			rightSum = rightSum - nums[i];
			if (rightSum == leftSum) // before only comparing bcz 0, case is there, i.e 0th elemnt can be any number,
										// but right side might be same +ve & -ve numbers which makes right sum == 0,
										// same for rightSide case.
				return i;
			leftSum = leftSum + nums[i];
		}
		return -1;
	}
}