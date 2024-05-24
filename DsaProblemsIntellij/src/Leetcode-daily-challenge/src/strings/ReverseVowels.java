package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ReverseVowels {
	public String reverseVowels(String s) {
		char[] charArray = s.toCharArray();
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

		int l = 0;
		int n = s.length();
		int r = n - 1;
		while (l < r) {
			if (!set.contains(charArray[l]))
				l++;
			if (!set.contains(charArray[r]))
				r--;
			if (set.contains(charArray[l]) && set.contains(charArray[r])) {
				char c = charArray[l];
				charArray[l] = charArray[r];
				charArray[r] = c;
				l++;
				r--;
			}
		}

		return String.valueOf(charArray);
	}
}