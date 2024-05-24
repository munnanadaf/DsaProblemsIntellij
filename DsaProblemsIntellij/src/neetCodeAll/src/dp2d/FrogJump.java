package dp2d;


// can only jump on stones, if last jump is k, and cur jump is k+1 or k or k-1;
// check if frog can cross the river, i.e last stone.
class FrogJump {
	boolean dp[][];

	public boolean canCross(int[] stones) {
		int n = stones.length;
		dp = new boolean[n][n];
		if (stones[1] != 1)
			return false;
		return helpCrossFrog(stones, 0, 1);
	}

	public boolean helpCrossFrog(int[] stones, int lastInd, int curInd) {
		if (curInd == stones.length - 1)
			return true;
		int lastJump = stones[curInd] - stones[lastInd];
		int nextIndex = curInd + 1;
		if (dp[lastInd][curInd])
			return false;
		while (nextIndex < stones.length && (stones[curInd] + lastJump + 1) >= stones[nextIndex]) {
			int newJump = stones[nextIndex] - stones[curInd];
			int jump = newJump - lastJump;
			if (jump >= -1 && jump <= 1) {
				if (helpCrossFrog(stones, curInd, nextIndex))
					return true;
			}
			nextIndex++;
		}
		dp[lastInd][curInd] = true;
		return false;
	}
}