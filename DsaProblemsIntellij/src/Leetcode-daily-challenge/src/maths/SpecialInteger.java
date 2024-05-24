package maths;

class SpecialInteger {
	public int findSpecialInteger(int[] arr) {
		int n = arr.length;
		int prev = arr[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == prev)
				count++;
			else {
				count = 1;
				prev = arr[i];
			}
			if (count > n / 4)
				return arr[i];
		}
		return prev;

	}
}
