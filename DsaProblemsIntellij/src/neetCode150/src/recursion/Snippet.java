package recursion;

public class Snippet {
//	After reading some good sharing solutions, I'd like to show them together. You can see different ideas in the code.

//	nest myPow
	public static double myPow1(double x, int n) {
		if (n < 0)
			return 1 / x * myPow1(1 / x, -(n + 1));
		if (n == 0)
			return 1;
		if (n == 2)
			return x * x;
		if (n % 2 == 0)
			return myPow1(myPow1(x, n / 2), 2);
		else
			return x * myPow1(myPow1(x, n / 2), 2);
	}

//	2. double myPow
	public static double myPow2(double x, int n) {
		if (n == 0)
			return 1;
		double t = myPow2(x, n / 2);
		if (n % 2 == 0)
			return n < 0 ? 1 / x * t * t : x * t * t;
		else
			return t * t;
	}

//	3. double x
	public static double myPow3(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPow3(x * x, n / 2) : x * myPow3(x * x, n / 2);
	}

//	4. iterative one
	public static double myPow4(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double ans = 1;
		while (n > 0) {
			if ((n & 1) == 1)
				ans *= x;
			x *= x;
			n >>= 1;
		}
		return ans;
	}
}
