package bits;

class MaxOddBinaryNumber {
	public static String maximumOddBinaryNumber(String s) {
		int countOnes = 0;

		// Count the number of '1's in the binary string
		for (char c : s.toCharArray()) {
			if (c == '1') {
				countOnes++;
			}
		}

		// Construct the maximum odd binary number
		StringBuilder sb = new StringBuilder();
		if (countOnes % 2 == 0) {
			sb.append('1'); // If countOnes is even, we need an extra '1' at the beginning
		}
		for (int i = 1; i <= s.length() - countOnes; i++) {
			sb.append('0'); // Place '0's at the remaining positions
		}
		for (int i = 0; i < countOnes - 1; i++) {
			sb.append('1'); // Place remaining '1's
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "0101";
		System.out.println(maximumOddBinaryNumber(s));
	}
}