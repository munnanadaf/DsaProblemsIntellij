package dp;

import java.util.Arrays;

class HouseRobber2 {
//    public int rob(int[] nums) {
//         if(nums.length == 1)return nums[0];
//         int one = helper(nums,0,nums.length-2);
//         int two = helper(nums,1,nums.length-1);
//         return Math.max(one,two);
//     }
//     public int helper(int nums[],int start,int n){
//         if(n < start)return 0;
//         if(n == start)return nums[start];
//         return Math.max(helper(nums,start,n-1),helper(nums,start,n-2) + nums[n]);
//     }

	int dp[][];

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		dp = new int[nums.length + 1][2];
		for (int i[] : dp)
			Arrays.fill(i, -1);

		int one = helper(nums, 0, nums.length - 2, 0);
		int two = helper(nums, 1, nums.length - 1, 1);

		return Math.max(one, two);
	}

	public int helper(int nums[], int start, int n, int idx) {
		if (n < start)
			return 0;
		if (n == start)
			return dp[n][idx] = nums[start];
		if (dp[n][idx] != -1)
			return dp[n][idx];
		return dp[n][idx] = Math.max(helper(nums, start, n - 1, idx), helper(nums, start, n - 2, idx) + nums[n]);
	}

	// public int rob(int[] nums) {
	// if(nums.length == 1)return nums[0];
	// int dp[][] = new int[nums.length + 1][2];
	// int one = HouseRobberOne(nums,1,nums.length-1,dp,0);
	// int two = HouseRobberOne(nums,2,nums.length,dp,1);
	// return Math.max(one,two);
	// }

	// public int HouseRobberOne(int []nums,int start,int end,int[][] dp,int idx){
	// dp[start][idx] = nums[start - 1];
	// for(int i = start;i<end;i++){
	// dp[i+1][idx] = Math.max(dp[i][idx],dp[i-1][idx] + nums[i]);
	// }
	// return dp[end][idx];
	// }
}