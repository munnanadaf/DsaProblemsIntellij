package searching;

// O(sqrt(logn)) time
public class SqrtUsingBinSearch {
	static int ans = 0;

	public static int sqrt(int n, int l, int h) {
		int mid = (l + h) / 2;
		while (h >= l) {
			if (mid * mid <= n) {
				ans = mid;
				return sqrt(n, mid + 1, h);
			}

			else if (mid * mid > n) {
				return sqrt(n, l, mid - 1);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(25, 0, 25));
	}
}
