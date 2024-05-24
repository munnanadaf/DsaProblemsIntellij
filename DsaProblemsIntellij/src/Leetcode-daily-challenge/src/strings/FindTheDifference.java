package strings;

public class FindTheDifference {

	public static char findTheDifference(String s, String t) {
		char c = 0;
		for (char cs : s.toCharArray())
			c ^= cs; // there is difference in c^=cs & c = c^cs, in first case auto type cast
		for (char ct : t.toCharArray())
			c ^= ct;
		return c;
	}

	public static void main(String[] args) {
		String t = "abcde";
		String s = "abcd";
		System.out.println(findTheDifference(s, t));
	}
}