package randomProblems;

import java.util.Iterator;

public class RomanToInteger {

	public static void main(String[] args) {
		romanToInteger("MMCDXXV");
	}

	public static void romanToInteger(String s) {
		char[] numbers = s.toCharArray();
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != s.length() - 1 && getValue(s.charAt(i)) > getValue(s.charAt(i + 1))) {
				int n1 = getValue(s.charAt(i));
				int n2 = getValue(s.charAt(i + 1));
				n = n + n1 + n2;
				i++;
//				in case ith value is smaller than i+1th MMCDXXV i.e "MCD" 
				if ((i + 1) < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
					i--;
					n = n - n2;
				}
			} else if (i != s.length() - 1 && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
				int n1 = getValue(s.charAt(i));
				int n2 = getValue(s.charAt(i + 1));
				n = n + n2 - n1;
				i++;
//				in case ith value is smaller than i+1th i.e "MCD" 
				if ((i + 1) < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
					i--;
					n = n - n2;
				}
			} else {
				n = n + getValue(s.charAt(i));
			}
		}

		System.out.println("Number in integer " + n);
	}

	public static int getValue(char c) {
		if (c == 'I') {
			return 1;
		}
		if (c == 'V') {
			return 5;
		}
		if (c == 'X') {
			return 10;
		}
		if (c == 'L') {
			return 50;
		}
		if (c == 'C') {
			return 100;
		}
		if (c == 'D') {
			return 500;
		}
		if (c == 'M') {
			return 1000;
		}
		return -1;
	}

}
