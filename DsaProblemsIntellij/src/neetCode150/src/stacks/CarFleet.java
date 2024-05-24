package stacks;

import java.util.Arrays;
import java.util.Stack;

class CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {
		Stack<Double> stack = new Stack<>();
		int[][] current = new int[position.length][2];
		for (int i = 0; i < current.length; i++) {
			current[i] = new int[] { position[i], speed[i] };
		}
		Arrays.sort(current, java.util.Comparator.comparingInt(o -> o[0]));
		for (int i = current.length - 1; i >= 0; i--) {
			double currTime = (double) (target - current[i][0]) / current[i][1];
			// If the condition is true, there is a car fleet, continue on
			if (!stack.isEmpty() && currTime <= stack.peek())
				continue;
			// If the condition is false, push the current time onto the stack
			else
				stack.push(currTime);
		}
		return stack.size();
	}
}