package graphs;

import java.util.HashMap;
import java.util.Map;

class VerifyingAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> mapping = new HashMap<>();
		for (int i = 0; i < order.length(); i++)
			mapping.put(order.charAt(i), i);
		for (int i = 0; i < words.length - 1; i++) {
			if (!isSorted(words[i], words[i + 1], mapping))
				return false;
		}
		return true;
	}

	public boolean isSorted(String w1, String w2, Map<Character, Integer> mapping) {
		int i = 0, j = 0;
		while (i < w1.length() && j < w2.length()) {
			int idx1 = mapping.get(w1.charAt(i));
			int idx2 = mapping.get(w2.charAt(j));
			if (idx1 < idx2)
				return true;
			else if (idx1 > idx2)
				return false;
			else {
				i++;
				j++;
			}
		}
		if (w1.length() > w2.length())
			return false;
		return true;
	}
}