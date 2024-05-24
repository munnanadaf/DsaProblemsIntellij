package dp;

public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int dp[] = new int[cost.length];
		return Math.min(minCostHelp(cost, 0, dp), minCostHelp(cost, 1, dp));

//		for (int i = 2; i < cost.length; i++) {
//			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
//		}
//		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}

	public int minCostHelp(int[] cost, int ind, int[] dp) {
		if (ind >= cost.length)
			return 0;
		if (dp[ind] != 0)
			return dp[ind];
		return dp[ind] = cost[ind] + Math.min(minCostHelp(cost, ind + 1, dp), minCostHelp(cost, ind + 2, dp));
	}
}
