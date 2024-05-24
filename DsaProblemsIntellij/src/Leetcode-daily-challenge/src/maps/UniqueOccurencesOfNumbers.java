package maps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UniqueOccurencesOfNumbers {
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> freq = new HashMap<>();
		Set<Integer> uniqueSet = new HashSet<>();
		for (int num : arr) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		for (int value : freq.values()) {
			if (!uniqueSet.add(value))
				return false;
		}
		return true;
	}
}