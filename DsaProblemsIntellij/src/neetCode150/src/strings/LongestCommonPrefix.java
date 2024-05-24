package strings;

import java.util.Arrays;

// if only 1 element return the element itself
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] str = { "flower", "flow", "flight" };
//		longestCommonPrefix(str);
		System.out.println(lcp(str) + " **************8");
	}

//	O(MaxLeng*nlog(n)) solution
	public static String lcp(String[] str) {
		Arrays.sort(str);
		String pref = "";
		if (str.length == 0)
			return "";
		if (str.length == 1)
			return str[0];
		int endIndex = Math.min(str[0].length(), str[str.length - 1].length());

		int i = 0;
		while (i < endIndex) {
			if (str[0].charAt(i) == str[str.length - 1].charAt(i)) {
				pref = pref + str[0].charAt(i);
			} else
				break;
			i++;
		}
		return pref;
	}

//	method 1 O(n*length) requires more time 
	public static String longestCommonPrefix(String[] str) {
		String pref = "";
		if (str.length > 1) {
			pref = getPrefix(str[0], str[1]);
		} else {
			pref = str[0];
		}
		if (str.length > 2) {
			for (int i = 2; i < str.length; i++) {
				pref = getPrefix(pref, str[i]);
			}
		}
		return pref;
	}

	public static String getPrefix(String s1, String s2) {
		int i = 0, j = 0;
		String tmp = "";
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				tmp = tmp + s1.charAt(i);
			} else
				break;
			i++;
			j++;
		}
		return tmp;
	}

}
