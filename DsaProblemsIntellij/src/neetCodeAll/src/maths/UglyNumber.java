package maths;

class UglyNumber {
	public boolean isUgly(int n) {
		int num = n;
		if (num == 1)
			return true;
		if (num == 0)
			return false;
		while (num % 2 == 0)
			num = num / 2;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		return num == 1;
	}
}