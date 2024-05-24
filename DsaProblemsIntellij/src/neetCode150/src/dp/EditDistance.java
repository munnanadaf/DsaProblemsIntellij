package dp;

class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}

	public static int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];

		// Base cases
		// Initializing First row
		for (int i = 0; i <= l2; i++)
			dp[0][i] = i;
		// Initializing First col
		for (int i = 0; i <= l1; i++)
			dp[i][0] = i;

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
							Math.min(dp[i - 1][j], // delete
									dp[i][j - 1]) // insert
					);
			}
		}

		return dp[l1][l2];
	}

	public int minDistance1(String word1, String word2) {
		int[][] dp = new int[word1.length()][word2.length()];
		return minDistanceHelper(word1, word2, 0, 0, dp);
	}

	private int minDistanceHelper(String word1, String word2, int index1, int index2, int[][] dp) {
		if (index1 == word1.length())
			return word2.length() - index2;
		if (index2 == word2.length())
			return word1.length() - index1;

		if (dp[index1][index2] > 0)
			return dp[index1][index2];

		int result;
		if (word1.charAt(index1) == word2.charAt(index2)) {
			result = minDistanceHelper(word1, word2, index1 + 1, index2 + 1, dp);
		} else {
			// replace char
			result = 1 + minDistanceHelper(word1, word2, index1 + 1, index2 + 1, dp);

			// delete char from word1
			result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1 + 1, index2, dp));

			// delete char from word2
			result = Math.min(result, 1 + minDistanceHelper(word1, word2, index1, index2 + 1, dp));
		}

		dp[index1][index2] = result;
		return result;
	}
}