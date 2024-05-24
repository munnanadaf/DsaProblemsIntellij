package arrays;

public class SortColors {
	public void sortColors(int nums[]) {
		int len = nums.length;
		if (len < 2)
			return;

		int left = 0;
		int right = len - 1;
		int current = 0;
		while (current <= right) {
			if (nums[current] == 0) {
				swap(nums, left, current);
				left++;
				current++;
			} else if (nums[current] == 1) {
				current++;
			} else {
				swap(nums, right, current);
				right--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;

	}
}
