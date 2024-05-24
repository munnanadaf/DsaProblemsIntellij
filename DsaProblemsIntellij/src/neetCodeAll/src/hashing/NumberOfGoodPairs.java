package hashing;

import java.util.HashMap;
import java.util.Map;

class NumberOfGoodPairs {
	public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		int n = nums.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (freq.containsKey(nums[i])) {
				int tmp = freq.get(nums[i]);
				ans = ans + tmp; // two pairs means, 1 good pair, pair -1;
				freq.put(nums[i], tmp + 1);
			} else {
				freq.put(nums[i], 1);
			}
		}
		return ans;
		// int count = 0;
		// int n = nums.length;
		// for(int i = 0;i<n;i++){
		// for(int j = i+1;j<n;j++){
		// if(nums[i]==nums[j])
		// count++;
		// }
		// }
		// return count;
	}
}