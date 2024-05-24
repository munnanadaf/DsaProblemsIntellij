package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SetMismatch {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 3, 5 };
		for (int i : findErrorNums(a)) {
			System.out.print(i + " ");
		}
	}

	public static int[] findErrorNums(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int a[] = new int[2];
		int n = nums.length;
		int realSum = (n * (n + 1)) / 2;
		int sum = 0;
		Set<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (!hashSet.add(nums[i])) {
				a[0] = nums[i];
			}
		}

		a[1] = realSum - (sum - a[0]);

		return a;
	}
}