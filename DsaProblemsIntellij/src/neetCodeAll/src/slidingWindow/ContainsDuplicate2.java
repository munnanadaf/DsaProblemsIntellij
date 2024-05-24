package slidingWindow;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate2 {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int a[] = { 1, 0, 1, 1 };
		int k = 1;
		System.out.println(containsNearbyDuplicate(a, k));
	}
}