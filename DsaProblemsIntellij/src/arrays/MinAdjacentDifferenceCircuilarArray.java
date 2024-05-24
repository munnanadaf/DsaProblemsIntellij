package arrays;

public class MinAdjacentDifferenceCircuilarArray {
	// Function to find minimum adjacent difference in a circular array.
	// arr[]: input array
	// n: size of array
	public static int minAdjDiff(int a[], int n) {
		int dif = Math.abs(a[1] - a[0]);
		// Your code here
		for (int i = 1; i < n; i++) {
			if (i == (n - 1)) {
				dif = Math.min(dif, Math.abs(a[n - 1] - a[0]));
			} else {
				dif = Math.min(dif, Math.abs(a[i + 1] - a[i]));
			}
		}

		return dif;

	}
}
