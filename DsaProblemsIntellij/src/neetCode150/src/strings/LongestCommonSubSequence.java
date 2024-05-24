package strings;

import java.util.Arrays;

public class LongestCommonSubSequence {

//	recursion
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
			return 0;
		return lcsHelp(text1, text2, text1.length(), text2.length());
	}

	public int lcsHelp(String text1, String text2, int ind1, int ind2) {
		if (ind1 <= 0 || ind2 <= 0)
			return 0;
		if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
			return 1 + lcsHelp(text1, text2, ind1 - 1, ind2 - 1);
		return Math.max(lcsHelp(text1, text2, ind1, ind2 - 1), lcsHelp(text1, text2, ind1 - 1, ind2));
	}

//	memorization
	public int longestCommonSubsequence1(String text1, String text2) {
		if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
			return 0;
		int n1 = text1.length();
		int n2 = text2.length();
		int dp[][] = new int[n1 + 1][n2 + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return lcsHelp1(text1, text2, n1, n2, dp);
	}

	public int lcsHelp1(String text1, String text2, int ind1, int ind2, int[][] dp) {
		if (ind1 <= 0 || ind2 <= 0)
			return 0;
		if (dp[ind1][ind2] != -1)
			return dp[ind1][ind2];
		if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
			return dp[ind1][ind2] = 1 + lcsHelp1(text1, text2, ind1 - 1, ind2 - 1, dp);
		return dp[ind1][ind2] = Math.max(lcsHelp1(text1, text2, ind1, ind2 - 1, dp),
				lcsHelp1(text1, text2, ind1 - 1, ind2, dp));
	}

//	tabulation
	public int longestCommonSubsequence2(String text1, String text2) {
		if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
			return 0;
		int n1 = text1.length();
		int n2 = text2.length();
		int dp[][] = new int[n1 + 1][n2 + 1];
		// row
		for (int i = 0; i <= n1; i++)
			dp[i][0] = 0;
		// col
		for (int i = 0; i <= n2; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
//				 index-1 bcz we have taken dp of size n+1 but we have only n elements in the string, it should not give array index out of the bounds exception
				if (text1.charAt(i - 1) == text2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n1][n2];
	}
}
