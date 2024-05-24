package dp2d;

import java.util.Arrays;

class SolvingQuestionsWithBrainPower {
	long dp[];

	public long mostPoints(int[][] questions) {
		int n = questions.length;
		dp = new long[n];
		Arrays.fill(dp, -1);
		long res = 0;
		if (questions.length == 2)
			return Math.max(questions[0][0], questions[1][0]);
		return helpGetMostPoints(questions, 0);
	}

	public long helpGetMostPoints(int[][] questions, int ind) {
		if (ind >= questions.length)
			return 0;
		if (dp[ind] != -1)
			return dp[ind];
		long take = questions[ind][0] + helpGetMostPoints(questions, ind + questions[ind][1] + 1); // +1 bcz started
																									// from 0.
		long notTake = helpGetMostPoints(questions, ind + 1);
		return dp[ind] = Math.max(take, notTake);
	}

}