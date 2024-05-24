package matrix;

class NumberOfLaserBeamsInABank {
	public static int numberOfBeams(String[] bank) {
		int prevRowCount = 0;
		int total = 0;

		for (String row : bank) {
			int curRowCount = calc(row);
			if (curRowCount == 0)
				continue;
			total += curRowCount * prevRowCount;
			prevRowCount = curRowCount;
		}
		return total;
	}

	private static int calc(String s) {
		int count = 0;
		for (char c : s.toCharArray())
			count += c - '0';
		return count;
	}

	public static void main(String[] args) {
		String matrix[] = { "011001", "000000", "010100", "001000" };
		System.out.println(numberOfBeams(matrix));

	}
}