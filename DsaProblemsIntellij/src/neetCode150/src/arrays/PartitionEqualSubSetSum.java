package arrays;

import java.util.Arrays;

class PartitionEqualSubSetSum {
	public static void main(String[] args) {
		int a[] = {1,2,3,5};
		System.out.println(canPartition(a));
	}

	public static boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Arrays.sort(nums);
		int n = nums.length - 1;
		int leftSum = nums[0];
		int rightSum = nums[n];
		int i = 0;
		while (i < n) {
			if (leftSum < rightSum) {
				i++;
				leftSum = leftSum + nums[i];
			} else if (leftSum > rightSum) {
				n--;
				rightSum = rightSum + nums[n];
			} else
				return true;
		}
		return false;
	}
}