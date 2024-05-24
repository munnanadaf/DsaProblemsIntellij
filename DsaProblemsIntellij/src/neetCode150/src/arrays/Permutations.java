package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		for (List<Integer> i : permuteUnique(a)) {
			System.out.println(i);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!used[i]) {
					used[i] = true;
					tempList.add(nums[i]);
					backtrack(list, tempList, nums, used);
					used[i] = false;
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		permute(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0, res); // int[] 2 List<Integer>
		return res;
	}

	public static void permute(List<Integer> nums, int i, List<List<Integer>> res) {
		if (i == nums.size())
			res.add(nums);
		else
			for (int j = i; j < nums.size(); j++) {
				Collections.swap(nums, i, j);
				permute(new LinkedList<Integer>(nums), i + 1, res);
				Collections.swap(nums, i, j);
			}
	}
}
