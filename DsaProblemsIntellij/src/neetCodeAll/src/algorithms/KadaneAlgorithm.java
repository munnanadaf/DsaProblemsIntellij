package algorithms;

public class KadaneAlgorithm {
	// Function to find maximum sum contiguous subarray in a given set of integers
	public static int kadane(int[] arr, int n) {
		// Stores maximum sum subarray found so far
		int final_ans = Integer.MIN_VALUE;
		// Stores the maximum sum of subarray ending at the current position
		int curr = 0;

		// Traverse the given array
		for (int i = 0; i < n; i++) {
			// if maximum sum is negative, set it to current element's value
			if (curr < 0) {
				curr = arr[i];
			}
			// else add it with the current element's value
			else {
				curr = curr + arr[i];
			}

			// update result if current subarray sum is found to be greater
			if (final_ans < curr) {
				final_ans = curr;
			}
		}
		return final_ans;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 2, -3, 4, 7, -5 };
		int n = arr.length;
		System.out.println("The maximum sum of a contiguous subarray is " + kadane(arr, n));
	}
}