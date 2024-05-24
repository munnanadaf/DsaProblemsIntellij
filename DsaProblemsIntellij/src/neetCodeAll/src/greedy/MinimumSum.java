package greedy;

import java.util.Arrays;

// min sum of two numbers formed by using given 4 digit number.
// take digits, sort, for first number ,0th at tens position, 2nd index at one's pos
// for second number. 1st index number at ten's position, 3rd index number at one's pos 
// sum of these will form lowest number possible.
class MinimumSum {
	public int minimumSum(int num) {
		int[] digits = new int[4];
		int i = 0;
		while (i <= 3) {
			digits[i++] = num % 10;
			num = num / 10;
		}
		Arrays.sort(digits);
		return (digits[0] * 10 + digits[2]) + (digits[1] * 10 + digits[3]);
	}
}