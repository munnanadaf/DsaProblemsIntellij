package strings;

// if all the characters in 2nd strings can be replaced by characters in 1st string.
class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		int map1[] = new int[200];
		int map2[] = new int[200];

		if (s.length() != t.length())
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (map1[s.charAt(i)] != map2[t.charAt(i)])
				return false;

			map1[s.charAt(i)] = i + 1;
			map2[t.charAt(i)] = i + 1;
		}
		return true;
	}
}