package arrays;

public class MaxSumSubArray {
	public static int maxSumSubArray(int a[]) {
		int res = a[0];
		int maxEnding = a[0];

		for (int i = 1; i < a.length; i++) {
			// first considering previous elements also \
			// then considering only current element to get max sum
			// whichever is max, that will be taken
			maxEnding = Math.max(maxEnding + a[i], a[i]);
			res = Math.max(res, maxEnding);
		}

		return res;
	}

	public static void main(String[] args) {
		int a[] = { 2, -9, 3, -3, 4, 5 };
		System.out.println(maxSumSubArray(a));
	}
}
