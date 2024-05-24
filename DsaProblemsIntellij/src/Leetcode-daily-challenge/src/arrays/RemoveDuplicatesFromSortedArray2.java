package arrays;

// retain max count 2 duplicates elements for each value, can be less than 2.
class RemoveDuplicatesFromSortedArray2 {
	// best solution.
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2]) // copy first 2 elements directly. // after 3rd element, copy at i only if its
											// > i-2th element(n != nums[i-2])
				nums[i++] = n;
		}
		return i;
	}
}