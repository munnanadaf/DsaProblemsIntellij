package binarySearch;

class FindFirstAndLastIndexOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int left = binSearch(nums, target, true);
		int right = binSearch(nums, target, false);
		if (left <= right)
			return new int[] { left, right };
		else
			return new int[] { -1, -1 };
	}

	public int binSearch(int[] nums, int target, boolean findLeft) {
		int low = 0;
		int high = nums.length - 1;
		int index = -1;
		while (low <= high) {
			int m = low + (high - low) / 2;
			if (nums[m] == target) {
				index = m;
				if (findLeft)
					high = m - 1;
				else
					low = m + 1;
			} else if (nums[m] < target)
				low = m + 1;
			else
				high = m - 1;
		}
		return index;
	}
}