package stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaximumSubArrayMinProduct {
	
	// optimal solution, using prefix sum & monotonic stack
	public int maxSumMinProduct(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        long dp[] = new long[n+1], res = 0;
        long mod = (long)(1e9+7);
        for(int i = 0;i<n;i++){
            dp[i+1] = dp[i]+nums[i];
        }
        for(int i = 0;i<=n;i++){
            while(!st.isEmpty() && (i==n || nums[i]<nums[st.peek()])){ // maintain monotonically increasing stack
                int j = st.pop();
                res = Math.max(res,(dp[i]-dp[st.isEmpty()?0:st.peek()+1])*nums[j]);
            }
            st.push(i);
        }
        return (int) (res%mod);
    }
	
	
	// brute force + dp, memery limit exceeded.
	public int maxSumMinProduct1(int[] nums) {
		long mod = (int) (1e9 + 7);
		int max = 0;
		int n = nums.length;
		int dp[][] = new int[n][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				max = Math.max(max, maximizeMinProduct(nums, i, j, dp));
			}
		}
		return (int) (max % mod);
	}

	public int maximizeMinProduct(int[] nums, int start, int end, int[][] dp) {
		if (dp[start][end] != -1)
			return dp[start][end];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			sum += nums[i];
			min = Math.min(min, nums[i]);
		}
		return dp[start][end] = max = min * sum;
	}
}
