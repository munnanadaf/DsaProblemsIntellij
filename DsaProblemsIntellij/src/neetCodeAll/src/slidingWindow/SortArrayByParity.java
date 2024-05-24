package slidingWindow;

class SortArrayByParity {
	public static int[] sortArrayByParity(int[] nums) {
		int n = nums.length;
		int l = 0, r = 0;
		while (r < n) {
			if (nums[r] % 2 == 0) {
				int tmp = nums[l];
				nums[l] = nums[r];
				nums[r] = tmp;
				r++;
				l++;
			} else {
				r++;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		int a[] = { 3, 1, 2, 4 };
		for (int num : sortArrayByParity(a)) {
			System.out.print(num + " ");
		}
	}
}