package arrays;

import java.util.Arrays;

public class MeanAndMedian {
	// Function to find median of the array elements.
	public int median(int A[], int N) {

		Arrays.sort(A);
		int m;
		if (N % 2 == 0)
			return A[N / 2 - 1];
		else
			return A[N / 2];

		// Your code here
		// If median is fraction then conver it to integer and return
	}

	// Function to find median of the array elements.
	public int mean(int A[], int N) {
		// Your code here
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum = sum + A[i];
		}

		return (int) Math.floor(sum / N);
	}

}