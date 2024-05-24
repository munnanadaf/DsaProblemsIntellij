package dp;

import java.util.Arrays;

public class CodeWays {
	public static int numDecodings(String s) {
		return s.length() == 0 ? 0 : numDecodings(0, s);
	}

	private static int numDecodings(int p, String s) {
		int n = s.length();
		if (p == n)
			return 1;
		System.out.println(p + " " + s.charAt(p));
		if (s.charAt(p) == '0')
			return 0;
		int res = numDecodings(p + 1, s);
		if (p < n - 1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
			res += numDecodings(p + 2, s);
		return res;
	}

	public static void main(String[] args) {
		String s = "226";
		System.out.println(numDecodings(s));

	}

//	mem
	public int numDecodings1(String s) {
		Integer mem[] = new Integer[s.length() + 1];
		return numDecodingHelp(s, 0, mem);
	}

	public int numDecodingHelp(String s, int ind, Integer[] mem) {
		int n = s.length();

		if (ind == n)
			return 1;

		if (s.charAt(ind) == '0')
			return 0;

		if (mem[ind] != null)
			return mem[ind];

		int res = numDecodingHelp(s, ind + 1, mem);

		if (ind < n - 1 && (s.charAt(ind) == '1' || s.charAt(ind) == '2' && s.charAt(ind + 1) < '7')) {
			res = res + numDecodingHelp(s, ind + 2, mem);
		}
		return res;
	}

//    top down
	public int numDecodings3(String s) {
		int n = s.length();
		Integer mem[] = new Integer[n + 1];
		mem[n] = 1;
		return s.isEmpty() ? 0 : numDecodingHelp1(s, 0, mem);
	}

	public int numDecodingHelp1(String s, int ind, Integer[] mem) {
		int n = s.length();
		if (mem[ind] != null)
			return mem[ind];
		if (ind >= n)
			return 0;
		if (s.charAt(ind) == '0')
			return mem[ind] = 0;
		int res = numDecodingHelp1(s, ind + 1, mem);
		if (ind < n - 1 && (s.charAt(ind) == '1' || s.charAt(ind) == '2' && s.charAt(ind + 1) < '7')) {
			res = res + numDecodingHelp1(s, ind + 2, mem);
		}
		return mem[ind] = res;
	}
}
