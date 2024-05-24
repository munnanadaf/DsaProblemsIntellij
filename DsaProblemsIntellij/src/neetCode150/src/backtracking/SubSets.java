package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public static void main(String[] args) {

	}

//	List<List<Integer>> result;
//
//	public List<List<Integer>> subsets(int[] nums) {
//		result = new ArrayList();
//		if (nums == null || nums.length == 0)
//			return result;
//
//		subsets(nums, new ArrayList<Integer>(), 0);
//		return result;
//	}
//
//	private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
//		// base condition
//		if (index >= nums.length) {
//			result.add(new ArrayList<>(temp));
//			return;
//		}
//
//		// main logic
//		// case 1 : we pick the element
//		temp.add(nums[index]);
//		subsets(nums, temp, index + 1); // move ahead
//		temp.remove(temp.size() - 1);
//
//		// case 2 : we don't pick the element ( notice, we did not add the current
//		// element in our temporary list
//		subsets(nums, temp, index + 1); // move ahead
//	}

	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<>();
		return helpSubset(nums, new ArrayList<List<Integer>>(), 0, new ArrayList<Integer>());
	}

	public static List<List<Integer>> helpSubset(int[] nums, List<List<Integer>> res, int index,
			List<Integer> tmpList) {
		if (index == nums.length) {
			res.add(new ArrayList<>(tmpList));
			return res;
		}
		tmpList.add(nums[index]);
		helpSubset(nums, res, index + 1, tmpList);
		tmpList.remove(tmpList.size() - 1);
		helpSubset(nums, res, index + 1, tmpList);
		return res;
	}
}
