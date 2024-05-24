package dp;

import java.util.Arrays;

class PartitionArrayForMaxSubArraySum {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);
		return maxSum(arr, k, dp, 0, arr.length);
	}

	public int maxSum(int arr[], int k, int[] dp, int start, int n) {
		if (start >= n)
			return 0;
		if (dp[start] != -1)
			return dp[start];
		int curMax = 0, ans = 0;
		int end = Math.min(n, start + k); // to avoid out of bounds exception
		for (int i = start; i < end; i++) {
			curMax = Math.max(curMax, arr[i]);
			ans = Math.max(ans, curMax * (i - start + 1) + maxSum(arr, k, dp, i + 1, n));
		}
		return dp[start] = ans;
	}
}