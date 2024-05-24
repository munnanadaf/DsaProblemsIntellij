package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
	public static void main(String[] args) {
		String[] s = { "eat", "tea", "tan", "ate", "nat", "bat" };
		for (List<String> string : groupAnagrams(s)) {
			System.out.println(string + " ");
		}
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> resMap = new HashMap<>();
		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String sorted = new String(arr);
			if (!resMap.containsKey(sorted))
				resMap.put(sorted, new ArrayList<>());
			resMap.get(sorted).add(str);
		}

		return new ArrayList<>(resMap.values());
	}
}