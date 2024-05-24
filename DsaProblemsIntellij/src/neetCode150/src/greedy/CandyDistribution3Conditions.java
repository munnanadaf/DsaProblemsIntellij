package greedy;

import java.util.Arrays;

//1. each student should have atleast 1 candy
//2. higher rating student should have more candies than its neighbors
//3. only neighbor condition, other two neigbors can have equal candies
class CandyDistribution3Conditions {
	public int candy(int[] ratings) {
		int n = ratings.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);

		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}
		int sumOfCandies = 0;

		for (int i = 0; i < n; i++) {
			sumOfCandies += Math.max(left[i], right[i]);
		}

		return sumOfCandies;
	}
}