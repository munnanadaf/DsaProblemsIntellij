package maths;

class AddDigits {
	public int addDigits(int num) {
		while (num > 9)
			num = check(num);
		return num;
	}

	public int check(int num) {
		int n = 0;
		while (num != 0) {
			n += num % 10;
			num /= 10;
		}
		return n;
	}
}