package recursion;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
	public static void main(String[] args) {
		int a[] = { 2, 3, 5 };
		int t = 7;
		for (List<Integer> i : combinationSum(a, t)) {
			System.out.println(i + " *** ");
		}

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		return helpCombiSum(candidates, new ArrayList<List<Integer>>(), new ArrayList<>(), target, 0);
	}

	public static List<List<Integer>> helpCombiSum(int a[], List<List<Integer>> list, List<Integer> tmpList, int target,
			int index) {
		if (index == a.length) {
			if (target == 0) {
				list.add(new ArrayList<>(tmpList));
				return list;
			}
			return list;
		}
		if (a[index] <= target) {
			tmpList.add(a[index]);
			helpCombiSum(a, list, tmpList, target - a[index], index);
			tmpList.remove(tmpList.size() - 1);
		}
		helpCombiSum(a, list, tmpList, target, index + 1);
		return list;
	}
}