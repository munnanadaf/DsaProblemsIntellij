package slidingWindow;

class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int chars[] = new int[26];
		int start = 0;
		int maxCount = 0;
		int maxLength = 0;

		for (int end = 0; end < s.length(); end++) {

			chars[s.charAt(end) - 'A']++;

			maxCount = Math.max(maxCount, chars[s.charAt(end) - 'A']);

			if (end - start + 1 - maxCount > k) {
				chars[s.charAt(start) - 'A']--;
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;

		// Map<Character, Integer> map = new HashMap<>();
		// int left = 0, maxRepeat = 0, maxWindow = 0;
		// for(int right = 0; right < s.length(); right++) {
		// char ch = s.charAt(right);
		// if(!map.containsKey(ch)) {
		// map.put(ch, 0);
		// }
		// map.put(ch, map.get(ch) + 1);
		// maxRepeat = Math.max(maxRepeat, map.get(ch));

		// if(right - left + 1 - maxRepeat > k) {
		// char remove = s.charAt(left);
		// map.put(remove, map.get(remove) - 1);
		// left++;
		// }

		// maxWindow = Math.max(maxWindow, right - left + 1);
		// }

		// return maxWindow;
	}
}