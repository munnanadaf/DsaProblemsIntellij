package dp1D;

class IntegerBreak {
	public int integerBreak(int n) {
		if (n == 2 || n == 3) // 2<=n , 1*1, 2*1 = n-1 for n==2, n==3
			return n - 1;
		int res = 1;
		while (n > 4) {
			n = n - 3; // can always remove 3 from n as long as it is above 4.
			res = res * 3;
		}
		return n * res;
	}
}