//package arrays;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class SlidingWindowMaximum {
//	class Solution {
//		public int[] maxSlidingWindow(int[] nums, int k) {
//			int n = nums.length;
//			if (nums == null || n == 0)
//				return new int[0];
//			List<Integer> res = new ArrayList<>();
//			int i = 0;
//			int max = Integer.MIN_VALUE;
//			for (; i < k; i++) {
//				max = Math.max(max, nums[i]);
//			}
//			res.add(max);
//			while (i < n) {
//				max = Math.max(max, nums[i++]);
//				res.add(max);
//			}
//			return res.stream().mapToInt(num -> num).toArray();
//			;
//		}
//	}
//}