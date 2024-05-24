package arrays;

import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {
	// the idea is to compare them lexo graphically using string property of same
	// length & different lengths
	public String largestNumber(int[] nums) {
		int n = nums.length;
		String[] strArr = new String[n];
		int i = 0;
		for (int num : nums)
			strArr[i++] = String.valueOf(num);
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String ab = a + b;
				String ba = b + a;
				return ba.compareTo(ab) > 0 ? 1 : -1; // decreasing order// largest first
			}
		});
		StringBuilder sb = new StringBuilder();

		if (strArr[0].charAt(0) == '0') // even after sorting in descending, if it has only zeroes. return single "0"
			return "0";
		for (String num : strArr)
			sb.append(num);
		return sb.toString();
	}
}