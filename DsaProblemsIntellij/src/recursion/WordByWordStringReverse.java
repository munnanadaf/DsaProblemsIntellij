package recursion;

public class WordByWordStringReverse {

	public static String wordReverse(String s, int i, StringBuilder b) {
		if ((i < s.length() && s.charAt(i) == ' ') || i == 0) {
			subString(s, i, b);
		}
		if (i == 0) {
			return b.toString();
		}
		return wordReverse(s, i - 1, b);
	}

	private static String subString(String s, int i, StringBuilder b) {
		int j = 0;
		if (s.charAt(i) == ' ') {
			j = i + 1;
		} else {
			j = i;
		}

		while (j < s.length() && !(s.charAt(j) == ' ')) {
			b.append(s.charAt(j));
			j++;
		}
		b.append(' ');

		return b.toString();
	}

	public static void main(String[] args) {
		StringBuilder b = new StringBuilder();
		String r = "hello raju bvc";
		System.out.println(wordReverse(r, r.length() - 1, b));
	}

}
