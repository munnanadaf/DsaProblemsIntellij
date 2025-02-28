package binarySearch;

class SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = l + r - l / 2;
			if (nums[m] == target)
				return m;

			// left half sorted
			if (nums[m] >= nums[l]) {
				if (nums[m] > target && nums[l] <= target)
					r = m - 1;
				else
					l = m + 1;
			}
			// right half is sorted
			else {
				if (nums[m] < target && nums[r] >= target)
					l = m + 1;
				else
					r = m - 1;
			}
		}
		return -1;
	}
}