package binarySearch;

/**
 * // This is MountainArray's API interface. // You should not implement it, or
 * speculate about its implementation
 **/
interface MountainArray {
	public int get(int index);

	public int length();
}

class FindInMountainArray {
	public int findInMountainArray(int target, MountainArray mountainArr) {
		int length = mountainArr.length();
		int peakIndex = findPeakIndex(1, length - 2, mountainArr); // finds middle element that is max.
		int increasingIndex = binarySearch(0, peakIndex, target, mountainArr, false);
		if (mountainArr.get(increasingIndex) == target) // checking in first half, bcz we can return min index.
			return increasingIndex;
		int decreasingIndex = binarySearch(peakIndex + 1, length - 1, target, mountainArr, true);
		if (mountainArr.get(decreasingIndex) == target) // checking in 2nd half, if we could not find in first half.
			return decreasingIndex;
		return -1;
	}

	private int binarySearch(int low, int high, int target, MountainArray mountainArr, boolean reversed) {
		while (low != high) {
			int mid = low + (high - low) / 2;
			if (reversed) { // go in opposite direction for decreasing array
				if (mountainArr.get(mid) > target)
					low = mid + 1;
				else
					high = mid;
			} else {
				if (mountainArr.get(mid) < target)
					low = mid + 1;
				else
					high = mid;
			}
		}
		return low;
	}

	public int findPeakIndex(int low, int high, MountainArray mountainArr) {
		while (low != high) {
			int mid = low + (high - low) / 2;
			if (mountainArr.get(mid) < mountainArr.get(mid + 1))
				low = mid + 1;
			else
				high = mid; // decreasing slope.
		}
		return low;
	}
}