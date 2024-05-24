package arrays;

class RotateArrayToRightByK {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		rotate(a, 4);

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return;
		int n = nums.length;
		if (n < k)
			k = k % n;
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);

	}

	public static void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
		return;
	}

	public static void swap(int[] nums, int low, int high) {
		int tmp = nums[low];
		nums[low] = nums[high];
		nums[high] = tmp;

	}
}