package arrays;

public class MaxEvenOddSubArray {
	public static int maxEvenOddSubArrayElementsCount(int a[]) {
		int cur = 1;
		int res = 1;
		for (int i = 1; i < a.length; i++) {
			if ((a[i] % 2 == 0 && a[i - 1] % 2 != 0) || (a[i] % 2 != 0 && a[i - 1] % 2 == 0)) {
				cur++;
				res = Math.max(res, cur);
			} else {
				cur = 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 3, 4, 5, 6, 7 };
		System.out.println(maxEvenOddSubArrayElementsCount(a));
	}
}
