package arrays;

class MonotonicallyIncreasingOrDecreasingArray {
	public boolean isMonotonic(int[] nums) {
		int inc = 1;
		int dec = 1;
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1])
				inc++;
			else if (nums[i] < nums[i - 1])
				dec++;
			else {
				inc++;
				dec++;
			}
		}
		return (inc == n || dec == n) ? true : false;
	}
}