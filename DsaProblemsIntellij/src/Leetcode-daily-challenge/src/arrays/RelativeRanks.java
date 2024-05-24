package arrays;

import java.util.Arrays;

class RelativeRanks {
	public String[] findRelativeRanks(int[] score) {
		Integer[] index = new Integer[score.length];

		for (int i = 0; i < score.length; i++) {
			index[i] = i;
		}

		Arrays.sort(index, (a, b) -> (score[b] - score[a]));

		String[] result = new String[score.length];

		for (int i = 0; i < score.length; i++) {
			if (i == 0) {
				result[index[i]] = "Gold Medal";
			} else if (i == 1) {
				result[index[i]] = "Silver Medal";
			} else if (i == 2) {
				result[index[i]] = "Bronze Medal";
			} else {
				result[index[i]] = (i + 1) + "";
			}
		}

		return result;
	}
}