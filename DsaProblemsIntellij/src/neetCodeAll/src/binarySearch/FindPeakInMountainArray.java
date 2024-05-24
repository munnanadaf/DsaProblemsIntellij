package binarySearch;

class FindPeakInMountainArray {
	public int peakIndexInMountainArray(int[] arr) {
		int n = arr.length;
		return findPeakElement(arr, n);
	}

	public int findPeakElement(int arr[], int n) {
		int low = 0;
		int high = n - 2;
		while (low != high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < arr[mid + 1])
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
}