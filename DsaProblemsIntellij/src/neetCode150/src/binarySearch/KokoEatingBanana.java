package binarySearch;

class KokoEatingBanana {
	public int minEatingSpeed(int[] piles, int h) {
		int max = Integer.MIN_VALUE;
		for (int num : piles) {
			max = Math.max(max, num);
		}

		int l = 1, r = max;
		int res = max;
		while (l <= r) {
			int m = (r + l) / 2;
			int hrs = 0;
			for (int pile : piles)
				hrs += Math.ceil((double) pile / m);
			if (hrs <= h) {
				res = Math.min(res, m);
				r = m - 1;
			} else
				l = m + 1;
		}
		return res;
	}
}