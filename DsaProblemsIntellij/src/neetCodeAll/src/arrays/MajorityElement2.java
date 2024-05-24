package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// O(n), O(n) time & space using hashmap.
class MajorityElement2 {
	public List<Integer> majorityElement(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		int n = nums.length;
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		List<Integer> res = new ArrayList<>();
		for (int num : nums) {
			int occurence = freq.get(num);
			if (occurence > Math.floor(n / 3) && !res.contains(num)) {
				res.add(num);
			}
		}
		return res;
	}

	public List<Integer> majorityElement3(int[] nums) {
		int n = nums.length;
		int count1 = 0, count2 = 0; // for candidate1 & candidate2
		int candidate1 = 0; // can be majority element
		int candidate2 = 0; // can be majority element

		// pass 1 to find potential majority elements
		for (int i = 0; i < n; i++) {
			if (count1 == 0 && nums[i] != candidate2) {
				count1 = 1;
				candidate1 = nums[i];
			}

			else if (count2 == 0 && nums[i] != candidate1) {
				count2 = 1;
				candidate2 = nums[i];
			}

			else if (candidate1 == nums[i])
				count1++;

			else if (candidate2 == nums[i])
				count2++;

			else {
				count1--;
				count2--;
			}
		}

		List<Integer> res = new ArrayList<>();
		int threshold = n / 3;

		count1 = 0;
		count2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (candidate1 == nums[i])
				count1++;
			else if (candidate2 == nums[i])
				count2++;
		}

		if (count1 >= threshold)
			res.add(candidate1);
		if (count2 >= threshold)
			res.add(candidate2);
		return res;
	}

	// using java 8 streams
	public List<Integer> majorityElement2(int[] nums) {
		return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > (nums.length / 3)).map(e -> e.getKey())
				.collect(Collectors.toList());
	}
}