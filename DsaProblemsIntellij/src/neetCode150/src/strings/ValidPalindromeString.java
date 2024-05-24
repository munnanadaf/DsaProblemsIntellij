package strings;

class ValidPalindromeString {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		String s1 = "race a car";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) { 
//		^ means not matching
		String up = s.toUpperCase().replaceAll("[^A-Za-z0-9]", "");
		System.out.println(up + " **************");
		int i = 0;
		int j = up.length() - 1;
		if (up.length() == 0 || up.length() == 1)
			return true;
		while (i < j) {
			if (up.charAt(i) != up.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public boolean isPalindrome1(String s) {
		if (s == null)
			return false;
		if (s.isEmpty())
			return true;
		s = s.toLowerCase();

		int l = 0, r = s.length() - 1;
		while (l < r) {
			while (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
				if (l == r)
					return true;
			}
			while (!Character.isLetterOrDigit(s.charAt(r)))
				r--;

			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
}
