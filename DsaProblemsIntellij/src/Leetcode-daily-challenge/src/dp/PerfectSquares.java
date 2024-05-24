package dp;

class PerfectSquares {
	public int numSquares(int n) {
		int[] memo = new int[n + 1];
		return helper(n, memo);
	}

	public int helper(int n, int[] memo) {
		if (n < 4) // common sense , to form 3 we need 1+1+1 (3 perfect squares), for 2 we need 1+1
					// (2 perfect squares), for 1 we need 1 (1 perfect square).
			return n;

		if (memo[n] != 0)
			return memo[n];

		int ans = n;

		for (int i = 1; i * i <= n; i++) {
			int square = i * i;
			ans = Math.min(ans, 1 + helper(n - square, memo)); // least of all the possibilities
		}

		return memo[n] = ans;
	}

	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		int n = 4;
		System.out.println(ps.numSquares(n));
	}
}