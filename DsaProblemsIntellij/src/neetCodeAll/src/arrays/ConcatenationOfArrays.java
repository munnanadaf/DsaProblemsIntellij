package arrays;

class ConcatenationOfArrays {
	public int[] getConcatenation(int[] nums) {
		int n = nums.length;
		int ans[] = new int[2 * n];
		for (int i = 0, j = 0; j < (2 * n); i++, j++) {
			if (i == n)
				i = i % n;
			ans[j] = nums[i];
		}
		return ans;
	}
}