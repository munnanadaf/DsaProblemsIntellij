package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>();

		int left = 0, right = 0;
		int n = s.length();
		int len = 0;
		while (right < n) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			len = Math.max(len, right - left + 1);
			right++;
		}
		return len;
	}
}