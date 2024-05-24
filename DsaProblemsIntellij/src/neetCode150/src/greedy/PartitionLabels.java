package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		List<Integer> res = new ArrayList<>();
		int prev = -1;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			max = Math.max(map.get(ch), max);
			if (max == i) {
				res.add(max - prev);
				prev = max;
			}
		}
		return res;
	}
}