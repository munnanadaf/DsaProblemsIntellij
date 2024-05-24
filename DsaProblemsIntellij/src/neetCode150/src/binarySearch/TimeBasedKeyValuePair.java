package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeBasedKeyValuePair {
	Map<String, List<Pair>> timeMap;

	// int time = 0;
	public TimeBasedKeyValuePair() {
		timeMap = new HashMap<String, List<Pair>>();
	}

	public void set(String key, String value, int timestamp) {
		Pair p = new Pair(value, timestamp);
		if (timeMap.containsKey(key)) {
			timeMap.get(key).add(p);
		} else {
			List<Pair> list = new ArrayList<>();
			list.add(p);
			timeMap.put(key, list);
		}
	}

	public String get(String key, int timestamp) {
		if (!timeMap.containsKey(key))
			return "";
		List<Pair> list = timeMap.get(key);
		return binarySearch(list, 0, list.size() - 1, timestamp);
	}

	String binarySearch(List<Pair> list, int start, int end, int target) {
		int mid = 0;
		while (start < end) {
			mid = start + (end - start) / 2 + 1;
			if (list.get(mid).time < target) {
				start = mid;
			} else if (list.get(mid).time > target) {
				end = mid - 1;
			} else
				return list.get(mid).value;
		}
		return list.get(start).time > target ? "" : list.get(start).value;
	}
}

class Pair {
	String value;
	int time;

	Pair(String value, int time) {
		this.value = value;
		this.time = time;
	}
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */