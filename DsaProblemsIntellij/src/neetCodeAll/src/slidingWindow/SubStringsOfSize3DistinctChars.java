package slidingWindow;

import java.util.HashMap;
import java.util.Map;

class SubStringsOfSize3DistinctChars {
	public static int countGoodSubstrings(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int l = 0, r = 0;
		int n = s.length();
		int ans = 0;
		while (l < n && r < n) {
			char rc = s.charAt(r);
			map.put(rc, map.getOrDefault(rc, 0) + 1);
			if (r - l + 1 < 3) {
				r++;
			} else if (map.size() == 3) {
				ans++;
				char lc = s.charAt(l);
				map.remove(lc);
				l++;
				r++;
			} else {
				// case 3, when window size is more, but map size <3, duplicate chars
				char lc = s.charAt(l);
				map.put(lc, map.getOrDefault(lc, 0) - 1);
				if (map.get(lc) == 0)
					map.remove(lc);
				l++;
				r++;
			}
		}
		return ans;
	}
}