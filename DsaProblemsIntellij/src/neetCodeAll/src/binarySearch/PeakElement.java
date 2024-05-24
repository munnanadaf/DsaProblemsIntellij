package binarySearch;

class PeakElement {
	public static int findPeakElement(int[] nums) {
		return peakFinder(nums, 0, nums.length - 1);
	}

	public static int peakFinder(int[] nums, int low, int high) {
		if (low == high)
			return low;
		else if (low + 1 == high) {
			if (nums[low] > nums[high])
				return low;
			return high;
		} else {
			int mid = (high - low) / 2 + low;
			if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1])
				return mid;
			else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1])
				return peakFinder(nums, mid + 1, high);
			else
				return peakFinder(nums, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1 };
		System.out.println(findPeakElement(a));
	}
}