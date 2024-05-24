package dp;

import java.util.Arrays;

class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		// O(n^2)
		if (nums.length == 1)
			return 1;

		int[] LIS = new int[nums.length];
		Arrays.fill(LIS, 1);
		int maximumSoFar = 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
//				System.out.println("j inside "+j);
				if (nums[i] < nums[j]) {
					LIS[i] = Math.max(1 + LIS[j], LIS[i]);
				}
			}
			maximumSoFar = Math.max(maximumSoFar, LIS[i]);
		}
		return maximumSoFar;
	}

	public static void main(String[] args) {
		int a[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(a));
	}

//	public static int lengthOfLIS(int[] nums) {
//		if (nums == null || nums.length == 0)
//			return 0;
//		int n = nums.length;
//		int[][] mem = new int[n + 1][n + 1];
//		for (int[] row : mem)
//			Arrays.fill(row, -1);
//		return lengthOfLISHelp(nums, mem, 0, -1);
//	}

	public static int lengthOfLISHelp(int[] nums, int[][] mem, int ind, int prevIndex) {
		if (ind >= nums.length)
			return 0;
		if (mem[ind][prevIndex + 1] != -1)
			return mem[ind][prevIndex + 1];
		int len = lengthOfLISHelp(nums, mem, ind + 1, prevIndex);
		if (prevIndex == -1 || nums[ind] > nums[prevIndex]) {
			len = Math.max(len, 1 + lengthOfLISHelp(nums, mem, ind + 1, ind));
		}
		return mem[ind][prevIndex + 1] = len;
	}
}