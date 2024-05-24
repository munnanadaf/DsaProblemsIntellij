package arrays;

import java.util.Stack;
// circuilare greater element.
// assume st is traversing from front finding big element than current element from array from the back.
// coming from back side bcz it means st has elements from front side at the top, which helps to find circuilar next greater element for last element.
class NextGreaterElement2 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 0, 3 };
		for (int i : nextGreaterElements(a)) {
			System.out.print(i + " ");
		}
	}

	public static int[] nextGreaterElements(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			stack.push(nums[i]);
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			int number = nums[i];
			while (!stack.isEmpty() && stack.peek() <= nums[i]) {
				stack.pop();
			}

			nums[i] = stack.empty() ? -1 : stack.peek();
			stack.push(number);
		}

		return nums;
	}
//	 O(n) time & space
}