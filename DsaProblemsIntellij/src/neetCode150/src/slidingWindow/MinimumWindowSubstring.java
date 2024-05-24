package slidingWindow;

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		// // record hashmap to store the characters and their occurrence
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();
		// initialize need(the char we need)
		for (char c : t.toCharArray())
			need.put(c, need.getOrDefault(c, 0) + 1);
		int left = 0, right = 0;
		// range of the window
		int valid = 0;
		int start = 0, len = Integer.MAX_VALUE;
		while (right < s.length()) {
			// add char and expand the window
			char c = s.charAt(right);
			right++;
			// check char, if it's what we need, add to window and check if's enough
			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).equals(need.get(c)))
					valid++;
			}
			// check whether left side need to be shrink, keep shrink until the needed char
			// is removed
			while (valid == need.size()) {
				// update the minium window substring
				if (right - left < len) {
					start = left;
					len = right - left;
				}
				// remove the left-most char
				char d = s.charAt(left);
				// shrink the window
				left++;
				// update window
				if (need.containsKey(d)) {
					if (window.get(d).equals(need.get(d)))
						valid--;
					window.put(d, window.get(d) - 1);
				}
			}
		}
		// return substring or empty substring
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}
}