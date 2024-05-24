package strings;

public class LongestPalindromicSubString {
	private int start, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return s.substring(start, start + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		// came out bcz ith & jth characters are not matching so excluding current jth &
		// ith character
		if (maxLen < k - j - 1) {
			start = j + 1;
			maxLen = k - j - 1;
		}
	}
	
	public static void main(String[] args) {
		String s = "raajaariiiiiii";
		System.out.println(longestPalindromeDp(s));
	}

//	dp bottom up
	public static String longestPalindromeDp(String s) {
		if (s.length() == 0) {
			return "";
		}
		// Dp array for substring palindrome
		boolean[][] dp = new boolean[s.length()][s.length()];
		int start = 0, end = 0;

		for (int i = 0; i < s.length(); ++i) {
			for (int j = i; j >= 0; --j) {
				boolean startEqEnd = s.charAt(j) == s.charAt(i);

				if (i == j) {
					// If the same char: 'a' is palindrome
					dp[i][j] = true;
				} else if (i - j == 1) {
					// If length 2: 'ab' is palindrome when 'a' == 'b'
					dp[i][j] = startEqEnd;
				} else if (startEqEnd && dp[i - 1][j + 1]) {
					// Otherwise: string is palindrome if s(i) == s(j) and substring s(j + 1, i - 1)
					// is palindrome
					dp[i][j] = true;
				}

				if (dp[i][j] && i - j > end - start) {
					end = i;
					start = j;
				}
			}
		}

		return s.substring(start, end + 1);
	}
}