package twoPointers;

class SortedSquares {
	public int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int res[] = new int[n];
		int left = 0;
		int right = n - 1;
		int resInd = n - 1;
		while (left <= right) {
			// we know most negative will be on left side, so we can take left
			// side & compare with right side after taking squares & fill
			// the resultant array from right side.
			int leftSquare = nums[left] * nums[left]; 
			int rightSquare = nums[right] * nums[right];
			if (rightSquare > leftSquare) {
				res[resInd--] = rightSquare;
				right--;
			} else if (rightSquare < leftSquare) {
				res[resInd--] = leftSquare;
				left++;
			} else {
				res[resInd--] = leftSquare;
				left++;
			}
		}
		return res;
	}
}