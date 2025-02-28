package arrays;

class IsSubSequenceOfString2 {
	public boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		int n1 = s.length();
		int n2 = t.length();
		while (i < n1 && j < n2) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		if (i == n1)
			return true;
		else
			return false;
	}
}