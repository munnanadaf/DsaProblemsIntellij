package dp2d;

import java.util.Arrays;

class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int dp[][] = new int[n][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return contractFromBothSides(s, 0, s.length() - 1, dp);
	}

	public int contractFromBothSides(String s, int left, int right, int dp[][]) {
		if (left > right)
			return 0;
		if (left == right)
			return 1;
		if (dp[left][right] != -1)
			return dp[left][right];
		if (s.charAt(left) == s.charAt(right))
			return dp[left][right] = 2 + contractFromBothSides(s, left + 1, right - 1, dp);
		else
			return dp[left][right] = Math.max(contractFromBothSides(s, left + 1, right, dp),
					contractFromBothSides(s, left, right - 1, dp));
	}
}