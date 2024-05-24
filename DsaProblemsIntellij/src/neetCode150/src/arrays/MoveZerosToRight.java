package arrays;

class MoveZerosToRight {
	public void moveZeroes(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return;
		int count = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[count++] = nums[j];
			}
		}

		while (count < nums.length) {
			nums[count++] = 0;
		}
	}
}