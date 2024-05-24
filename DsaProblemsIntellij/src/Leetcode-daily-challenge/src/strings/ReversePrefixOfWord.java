package strings;

class ReversePrefixOfWord {
	public String reversePrefix(String word, char ch) {
		int n = word.length();
		int ind = 0;
		for (int i = 0; i < n; i++) {
			if (word.charAt(i) == ch) {
				ind = i;
				return helpReverse(word, ind);
			}
		}
		return word;
	}

	public String helpReverse(String word, int ind) {
		StringBuilder sb = new StringBuilder();
		int n = word.length();
		for (int i = ind; i >= 0; i--)
			sb.append(word.charAt(i));
		sb.append(word.substring(ind + 1));
		return sb.toString();
	}
}