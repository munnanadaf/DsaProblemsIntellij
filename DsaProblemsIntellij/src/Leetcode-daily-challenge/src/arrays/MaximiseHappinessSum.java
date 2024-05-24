package arrays;

import java.util.Arrays;

class MaximiseHappinessSum {
	public long maximumHappinessSum(int[] happiness, int k) {
		Arrays.sort(happiness);
		int n = happiness.length;
		long maxHappiness = 0;
		int ded = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (k == 0)
				return maxHappiness;
			if (i > 0 && happiness[i - 1] > 0) {
				happiness[i - 1] = happiness[i - 1] - (++ded);
				if (happiness[i - 1] < 0)
					happiness[i - 1] = 0;
			}
			maxHappiness += happiness[i];
			k--;
		}
		return maxHappiness;
	}
}