package dp2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// do revise it. important.
class BurstBalloons {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		List<Integer> updatedNums = new ArrayList<>();
		for (int i = 0; i < n; i++)
			updatedNums.add(nums[i]);
		updatedNums.add(1);
		updatedNums.add(0, 1);
		int[][] dp = new int[n + 1][n + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return dpMaximize(updatedNums.stream().mapToInt(k -> k).toArray(), dp, 1, nums.length);
	}

	public int dpMaximize(int[] nums, int[][] dp, int i, int j) {
		if (i > j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int maxi = Integer.MIN_VALUE;
		for (int ind = i; ind <= j; ind++) {
			int cost = (nums[i - 1] * nums[ind] * nums[j + 1]) + dpMaximize(nums, dp, i, ind - 1)
					+ dpMaximize(nums, dp, ind + 1, j);
			dp[i][j] = maxi = Math.max(maxi, cost);
		}
		return dp[i][j] = maxi;
	}
}