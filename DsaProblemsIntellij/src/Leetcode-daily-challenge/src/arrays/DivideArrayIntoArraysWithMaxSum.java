package arrays;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxSum {
	public static void main(String[] args) {
		int a[] = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
		System.out.println(divideArray(a, 2));
	}

	public static int[][] divideArray(int[] nums, int k) {
		int n = nums.length;
		int newN = n / 3;
		int res[][] = new int[newN][3];
		int l = 0;
		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i = i + 3) {
			for (int j = 0; j < 3; j++) {
				int rr = i + j;
				if (rr < n)
					res[l][j] = nums[rr];
			}
			l++;
		}
		for (int i = 0; i < newN; i++) {
			int prev = res[i][0];
			for (int j = 1; j < 3; j++) {
				if ((res[i][j] - prev) > k)
					return new int[0][0];
			}
		}
		return res;
	}
}
