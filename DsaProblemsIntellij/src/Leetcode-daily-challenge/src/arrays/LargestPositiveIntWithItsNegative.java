package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestPositiveIntWithItsNegative {
	public int findMaxK(int[] nums) {
		List<Integer> subList = new ArrayList<>();
		int max = -1;
		Arrays.sort(nums);
		for (int num : nums) {
			if (num > 0 && subList.contains((-1) * num))
				max = Math.max(max, num);
			else
				subList.add(num);
		}
		return max;
	}
}