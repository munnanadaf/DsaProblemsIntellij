package twoPointers;

public class MergeStringsAlternatively {
	public String mergeAlternately(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int i = 0, j = 0;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (i < m && j < n) {
			if (count % 2 == 0) {
				sb.append(word1.charAt(i++));
			} else {
				sb.append(word2.charAt(j++));
			}
			count++;
		}

		if (i < m) {
			sb.append(word1.substring(i));
		}
		if (j < n) {
			sb.append(word2.substring(j));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("hello");
	}
}