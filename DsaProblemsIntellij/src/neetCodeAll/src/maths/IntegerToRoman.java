package maths;

class IntegerToRoman {
	public String intToRoman(int num) {
		int intValues[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String romanValues[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < intValues.length; i++) {
			while (num >= intValues[i]) { // for same value unless it becomes less, taken care of 1,2, & 3, by default 4
											// has been included in the array.
				sb.append(romanValues[i]);
				num = num - intValues[i];
			}
		}
		return sb.toString();
	}
}