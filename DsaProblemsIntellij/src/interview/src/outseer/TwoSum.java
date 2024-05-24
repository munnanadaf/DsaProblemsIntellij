package outseer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {

	public static List<List<Integer>> twoSum(int arr[], int sum) {
		int n = arr.length;
		Map<Integer, List<Integer>> resMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (resMap.containsKey(sum - arr[i])) {
				int curKey = sum - arr[i];
				resMap.get(curKey).add(curKey);
				resMap.get(curKey).add(arr[i]);
			} else {
				resMap.put(arr[i], new ArrayList<>());
			}
		}

		return resMap.values().stream().filter(c -> c.size() > 0).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		int arr[] = { 4, 6, 8, 12, 16, 2 };
		List<List<Integer>> res = twoSum(arr, 10);
		for (List<Integer> subRes : res) {
			System.out.println(subRes + " ");
		}
	}

}
