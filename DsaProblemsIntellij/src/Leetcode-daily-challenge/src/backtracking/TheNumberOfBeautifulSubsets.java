package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TheNumberOfBeautifulSubsets {
	public int beautifulSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, 0, res, new ArrayList<>(), k);
		return res.size();
	}

	public void backtrack(int nums[], int ind, List<List<Integer>> res, List<Integer> subRes, int k) {
		if (ind == nums.length) {
			if (subRes.size() > 0)
				res.add(new ArrayList<>(subRes));
			return;
		}
		if ((!subRes.contains(nums[ind] - k))) { // if nums[ind]-k = some element is not there
			subRes.add(nums[ind]);
			backtrack(nums, ind + 1, res, subRes, k);
			subRes.remove(subRes.size() - 1);
		}
		backtrack(nums, ind + 1, res, subRes, k); // without adding cur element

	}
}