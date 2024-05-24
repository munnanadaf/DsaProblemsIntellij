package arrays;

class countSuffixAndPrefixPairs {
	public int countPrefixSuffixPairs(String[] words) {
		int res = 0, n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isSuffixPrefix(words[i], words[j]))
					res++;
			}
		}
		return res;
	}

	public boolean isSuffixPrefix(String pref, String mainString) {
		int n1 = pref.length();
		int n2 = mainString.length();

		if (n1 > n2)
			return false;

		int i = 0;
		while (i < n1 && i < n2) {
			if (pref.charAt(i) != mainString.charAt(i))
				return false;
			i++;
		}

		int j = n1 - 1;
		int k = n2 - 1;

		while (j >= 0 && k >= 0) {
			if (pref.charAt(j) != mainString.charAt(k))
				return false;
			j--;
			k--;
		}
		return true;
	}
}