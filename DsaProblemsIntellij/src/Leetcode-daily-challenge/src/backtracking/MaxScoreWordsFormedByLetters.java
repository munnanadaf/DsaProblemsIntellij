package backtracking;

class MaxScoreWordsFormedByLetters {
	int[] max = new int[1];

	public int maxScoreWords(String[] words, char[] letters, int[] score) {
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0)
			return 0;
		int count[] = new int[score.length];
		for (char c : letters)
			count[c - 'a']++;
		int res = backtrack(words, count, score, 0);
		return res;
	}

	public int backtrack(String[] words, int[] count, int[] score, int ind) {
		int max = 0;
		for (int i = ind; i < words.length; i++) {
			int res = 0;
			boolean isValid = true;
			for (char c : words[i].toCharArray()) {
				count[c - 'a']--;
				res = res + score[c - 'a'];
				if (count[c - 'a'] < 0)
					isValid = false;
			}
			if (isValid) {
				res = res + backtrack(words, count, score, i + 1);
				max = Math.max(max, res);
			}
			// backtracking to original values
			for (char c : words[i].toCharArray()) {
				count[c - 'a']++;
				res = 0;
			}
		}
		return max;
	}
}