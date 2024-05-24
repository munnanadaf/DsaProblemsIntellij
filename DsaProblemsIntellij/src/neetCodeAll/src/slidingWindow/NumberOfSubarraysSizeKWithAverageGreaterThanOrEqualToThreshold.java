package slidingWindow;

class NumberOfSubarraysSizeKWithAverageGreaterThanOrEqualToThreshold {
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int n = arr.length;
		int ans = 0;
		int sum = 0;
		int minSum = k * threshold; // minSum sum for k subArray, i.e (minSum/k = threshold)
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (i < k - 1)
				continue;
			if (i > k - 1)
				sum -= arr[i - k];
			if (sum >= minSum) // when size == k then it will be executed
				ans++;
		}
		return ans;
	}
}