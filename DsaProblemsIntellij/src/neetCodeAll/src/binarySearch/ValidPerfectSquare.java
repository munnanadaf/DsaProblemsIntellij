package binarySearch;

class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		long l = 2;
		long r = num;
		while (l < r) {
			long m = l + (r - l) / 2;
			if (m * m == num)
				return true;
			else if (m * m < num)
				l = m + 1;
			else
				r = m;
		}
		return false;
	}
}