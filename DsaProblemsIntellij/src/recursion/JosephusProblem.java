package recursion;

public class JosephusProblem {

	public int josephus(int n, int k) {
		// Your code here
		int res = 0;
		for (int i = 1; i <= n; i++) {
			res = (res + k) % i;
		}
		return res + 1;
	}

}

class Solution {
	public int josephus(int n, int k) {
		// Your code here
		return (acc(n, k)) + 1;
	}

	public static int acc(int n, int k) {
		if (n == 1)
			return 0;
		return ((acc(n - 1, k) + k) % n);
	}

}