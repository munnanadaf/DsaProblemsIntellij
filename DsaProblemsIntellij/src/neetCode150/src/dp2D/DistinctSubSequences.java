package dp2D;

import java.util.Arrays;

class DistinctSubSequences {
	public int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		int dp[][] = new int[m][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return findDistinctSubSeq(s, t, 0, 0, dp);
	}

	public int findDistinctSubSeq(String s, String t, int ind1, int ind2, int[][] dp) {
		if (ind2 == t.length())
			return 1;
		if (ind1 == s.length())
			return 0;
		if (dp[ind1][ind2] != -1)
			return dp[ind1][ind2];
		if (s.charAt(ind1) == t.charAt(ind2))
			return dp[ind1][ind2] = findDistinctSubSeq(s, t, ind1 + 1, ind2 + 1, dp)
					+ findDistinctSubSeq(s, t, ind1 + 1, ind2, dp);
		else
			return dp[ind1][ind2] = findDistinctSubSeq(s, t, ind1 + 1, ind2, dp);
	}

}