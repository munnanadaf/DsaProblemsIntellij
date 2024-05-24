package recursion;

public class SubSetOfString {

	void subset(String s, String cur, int i) {
		if (i == s.length()) {
			System.out.println(cur);
			return;
		}

		// this makes i to become string length and whatever cur value will be there is
		// printed
		subset(s, cur, i + 1);

		// this updates cur value by a character and then above statement will be called
		// recursively till it becomes string length and then it will be printed
		subset(s, cur + s.charAt(i), i + 1);
	}

	public static void main(String[] args) {
		SubSetOfString obj = new SubSetOfString();
		obj.subset("hello", "", 0);
	}

}
