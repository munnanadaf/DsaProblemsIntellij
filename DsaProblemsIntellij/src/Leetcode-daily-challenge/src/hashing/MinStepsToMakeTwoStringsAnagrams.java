package hashing;

class MinStepsToMakeTwoStringsAnagrams {
	public int minSteps(String s, String t) {
		if (s.equals(t))
			return 0;
		int n = s.length(), ans = 0;
		int arr[] = new int[26];
		for (int i = 0; i < n; i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}

		for (int freq : arr) {
			if (freq > 0)
				ans += freq;
		}
		return ans;
	}
}