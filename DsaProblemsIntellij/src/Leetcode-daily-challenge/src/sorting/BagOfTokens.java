package sorting;

import java.util.Arrays;

class BagOfTokens {
	public int bagOfTokensScore(int[] tokens, int power) {
		Arrays.sort(tokens);
		int s = 0;
		int max = 0;
		int l = 0, r = tokens.length - 1;
		while (l <= r) {
			if (power >= tokens[l]) {
				power = power - tokens[l];
				s++;
				l++;
				max = Math.max(max, s);
			} else if (s > 0) {
				power = power + tokens[r];
				r--;
				s--;
			} else {
				break;
			}
		}
		return max;
	}
}