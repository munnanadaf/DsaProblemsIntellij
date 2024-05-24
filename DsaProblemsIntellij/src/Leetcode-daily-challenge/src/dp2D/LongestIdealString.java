package dp2D;

class LongestIdealString {
	public int longestIdealString(String s, int k) {
		int[][] dp = new int[s.length()][27];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 27; j++) {
				dp[i][j] = -1;
			}
		}
		return dfs(s, 0, k, 26, dp);
	}

	public int dfs(String s, int curPos, int k, int prevChar, int[][] dp) {
		if (curPos >= s.length())
			return 0;
		if (dp[curPos][prevChar] != -1)
			return dp[curPos][prevChar];
		int curChar = s.charAt(curPos) - 'a';
		int res = dfs(s, curPos + 1, k, prevChar, dp);
		if (prevChar == 26 || Math.abs(curChar - prevChar) <= k)
			res = Math.max(res, 1 + dfs(s, curPos + 1, k, curChar, dp));
		dp[curPos][prevChar] = res;
		return res;
	}
}