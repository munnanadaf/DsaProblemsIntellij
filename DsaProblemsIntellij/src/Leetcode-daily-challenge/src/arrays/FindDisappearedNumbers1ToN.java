package arrays;

import java.util.ArrayList;
import java.util.List;

class FindDisappearedNumbers1ToN {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		int arr[] = new int[n + 1];
		List<Integer> res = new ArrayList<>();
		for (int num : nums) {
			arr[num] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] != 1)
				res.add(i);
		}
		return res;
	}
}