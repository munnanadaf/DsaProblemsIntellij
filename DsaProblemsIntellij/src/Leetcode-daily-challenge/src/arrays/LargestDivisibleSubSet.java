package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestDivisibleSubSet {
	List<Integer> res;
	int[] mem;

	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		res = new ArrayList<>();
		mem = new int[nums.length];
		Arrays.fill(mem, -1);
		helper(nums, 0, new ArrayList<>(), 1); // prev = 1, it divides every number
		return res;
	}

	private void helper(int[] nums, int ind, List<Integer> curr, int prev) {
		if (curr.size() > res.size()) {
			res = new ArrayList<>(curr);
		}
		for (int i = ind; i < nums.length; i++) {
			if (curr.size() > mem[i] && nums[i] % prev == 0) {
				mem[i] = curr.size(); // new size
				curr.add(nums[i]); // adding new element
				helper(nums, i + 1, curr, nums[i]);
				curr.remove(curr.size() - 1); // backtracking;
			}
		}
	}

	public static void main(String[] args) {
		LargestDivisibleSubSet ls = new LargestDivisibleSubSet();
		int arr[] = { 1, 2, 4, 8 };
		for (int num : ls.largestDivisibleSubset(arr)) {
			System.out.println(num + " ");
		}
	}
}