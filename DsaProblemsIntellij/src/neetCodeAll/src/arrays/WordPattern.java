package arrays;

import java.util.HashMap;
import java.util.Map;

class WordPattern {
	public boolean wordPattern(String pattern, String s) {
		int n = pattern.length();
		String[] words = s.split(" ");
		if (n != words.length)
			return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char key = pattern.charAt(i);
			String word = words[i];
			if (map.containsKey(key) && !map.get(key).equals(word))
				return false;
			if (!map.containsKey(key) && map.containsValue(word))
				return false;
			map.put(key, word);
		}
		return true;
	}
}