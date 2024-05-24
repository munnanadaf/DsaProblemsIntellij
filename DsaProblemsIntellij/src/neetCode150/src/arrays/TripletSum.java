package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TripletSum {
	public static void main(String[] args) {
		int a[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(a));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					int sum1 = nums[lo] + nums[hi];
					if (sum1 == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi-1])
							hi--;

						lo++;
						hi--;
					} else if (sum1 < sum)
						lo++;

					else
						hi--;

				}

			}
		}

		return res;
	}
}