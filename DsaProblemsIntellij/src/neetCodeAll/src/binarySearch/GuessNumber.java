package binarySearch;

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number 1 if num is lower than the
 *         picked number otherwise return 0 int guess(int num);
 */

public class GuessNumber {
	public int guessNumber(int n) {
		if (guess(n) == 0)
			return n;
		if (guess(1) == 0)
			return 1;
		int low = 2;
		int high = n - 1;
		while (low <= high) {
			int m = low + (high - low) / 2;
			int res = guess(m);
			if (res == 0)
				return m;
			else if (res < 0)
				high = m - 1;
			else
				low = m + 1;
		}
		return 0;
	}

	public int guess(int m) {
		return 0;
	}
}