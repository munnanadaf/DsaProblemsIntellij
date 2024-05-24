package stacks;

import java.util.Stack;

class AsteroidsCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<>();
		int n = asteroids.length;
		for (int num : asteroids) {
			if (st.size() == 0 || (st.peek() < 0 && num > 0) || sameSign(num, st.peek())) {
				st.push(num);
			} else {
				while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(num))
					st.pop();
				if (st.size() == 0 || st.peek() < 0)
					st.push(num);
				else if (Math.abs(st.peek()) == Math.abs(num))
					st.pop();
			}
		}
		int res[] = new int[st.size()];
		int i = st.size() - 1;
		while (!st.isEmpty()) {
			res[i--] = st.pop();
		}
		return res;
	}

	public boolean sameSign(int a, int b) {
		if (a < 0 && b < 0)
			return true;
		else if (a > 0 && b > 0)
			return true;
		return false;
	}
}