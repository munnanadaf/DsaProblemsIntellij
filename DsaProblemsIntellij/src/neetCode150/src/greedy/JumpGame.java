package greedy;

// can reach last index using array value (value indicates how many index jumps we can make)
class JumpGame {

	public boolean canJump(int[] nums) {
		int goal = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
//			from current index can we reach goal? here goal is also an index.
			if (nums[i] + i >= goal) {
				goal = i;
			}
		}
		return goal == 0;
	}
}
