package greedy;

class MaxSubArraySum {
//	public int maxSubArray(int[] nums) {
//		int n = nums.length;
//		int max = Integer.MIN_VALUE, sum = 0;
//
//		for (int i = 0; i < n; i++) {
//			sum += nums[i];
//			max = Math.max(sum, max);
//
//			if (sum < 0)
//				sum = 0;
//		}
//
//		return max;
//	}

// ******************for printing maxsumsubarray*************
	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE, sum = 0;

		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (sum == 0)
				start = i;
			sum += nums[i];
			if (sum > max) {
				max = sum;
				end = i;
			}

			if (sum < 0)
				sum = 0;
		}
		for (int i = start; i <= end; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.print(maxSubArray(nums));
	}
}