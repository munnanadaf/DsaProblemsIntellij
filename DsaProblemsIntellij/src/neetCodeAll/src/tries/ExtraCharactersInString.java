package tries;

import java.util.Arrays;

public class ExtraCharactersInString {
	static int dp[] = new int[51]; // string max length;

	public static int minExtraChar(String s, String[] dictionary) {
		Arrays.fill(dp, -1);
		return minExtraCharHelper(s, dictionary, 0);
	}

	public static int minExtraCharHelper(String s, String[] dictionary, int i) {
		if (i == s.length())
			return 0;
		if (dp[i] == -1) {
			dp[i] = 1 + minExtraCharHelper(s, dictionary, i + 1); // initialise with 1 extra char, becomes 0
			for (String w : dictionary) {
				if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
					dp[i] = Math.min(dp[i], minExtraCharHelper(s, dictionary, i + w.length())); // taking next index
					// this step also resets previous dp[i] value to min(dp[i],minextra) if matches
				}
			}
		}
		System.out.println("i : " + i + " dp[i]" + dp[i]);
		return dp[i]; // all ith will have same ans
	}

	public static void main(String[] args) {
		String s = "leetscode";
		String[] dictionary = { "leet", "code", "leetcode" };
		System.out.println(minExtraChar(s, dictionary) + " answer***** ");
	}
}