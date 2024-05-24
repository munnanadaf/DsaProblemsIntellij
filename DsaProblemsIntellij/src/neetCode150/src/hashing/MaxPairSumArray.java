package hashing;

class MaxPairSumArray {
	public int maxSum(int[] nums) {
		int curMax = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((getMaxDigit(nums[i]) == getMaxDigit(nums[j])))
					curMax = Math.max(curMax, nums[i] + nums[j]);
			}
		}
		return curMax != 0 ? curMax : -1;
	}

	// public int maxSum(int[] nums) {
	// HashMap<Integer,Integer> map = new HashMap<>();
	// int ans = -1;
	// for(int i=0;i<nums.length;i++){
	// int currAns = getMaxDigit(nums[i]);
	// if(map.containsKey(currAns)){
	// if(nums[i] + map.get(currAns)>ans){
	// ans = nums[i] + map.get(currAns);
	// }
	// if(nums[i]>map.get(currAns)){
	// map.put(currAns,nums[i]);
	// }
	// }
	// else{
	// map.put(currAns,nums[i]);
	// }
	// }
	// return ans;
	// }

	public int getMaxDigit(int num) {
		int max = 0;
		while (num != 0) {
			int rem = num % 10;
			max = Math.max(rem, max);
			num = num / 10;
		}
		return max;
	}
}