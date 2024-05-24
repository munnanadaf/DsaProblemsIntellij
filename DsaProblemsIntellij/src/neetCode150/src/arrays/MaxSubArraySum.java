package arrays;

public class MaxSubArraySum {
//	public static int maxSubArray(int[] A) {
//		int maxSoFar = A[0], maxEndingHere = A[0];
//		for (int i = 1; i < A.length; ++i) {
//			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
//			maxSoFar = Math.max(maxSoFar, maxEndingHere);
//		}
//		return maxSoFar;
//	}
	public static void main(String[] args) {
		int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		maxSubArray(a);
	}

	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE, sum = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			max = Math.max(sum, max);
			System.out.println("at i = "+i+" sum : " + sum + " max : " + max +" nums[i] : "+nums[i]);
			if (sum < 0)
				sum = 0;
		}

		return max;
	}
}
