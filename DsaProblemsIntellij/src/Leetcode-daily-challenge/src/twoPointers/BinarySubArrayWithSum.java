package twoPointers;

class BinarySubArrayWithSum {
	public static int numSubarraysWithSum(int[] nums, int goal) {
		int i = 0, j = 0, temp = 0, sum = 0, count = 0;
		int n = nums.length;
		while (j < n) {
			sum = sum + nums[j];
			if (nums[j] == 1)
				temp = 0; // for restarting from next window
			if (sum > goal) {
				sum = sum - nums[i];
				i++;
			}
			while (sum == goal && i <= j) {
				temp++;
				sum = sum - nums[i]; // removing left number from window sum
				i++;
			}
			j++;
			count = count + temp; // even if temp is reset in the beginning, it would have already added to the count.
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 0, 1, 0, 1 };
		System.out.println(numSubarraysWithSum(arr, 2));
	}
}