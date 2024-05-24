package strings;

class PalindromicSubstrings {

	public int countSubstrings(String s) {
		int count[] = new int[1];
		if (s == null || s.length() == 0)
			return 0;

		for (int i = 0; i < s.length(); i++) { // i is the mid point
			extendPalindrome(s, count, i, i); // odd length;
			extendPalindrome(s, count, i, i + 1); // even length
		}

		return count[0];
	}

	private void extendPalindrome(String s, int[] count, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count[0]++;
			left--;
			right++;
		}
	}
}