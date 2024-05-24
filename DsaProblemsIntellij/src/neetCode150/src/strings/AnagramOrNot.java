package strings;

// same length, same no of characters, and should have same characters, oreder doesnt matter
public class AnagramOrNot {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "elloh";
		naiveMethod(s1, s2);
		System.out.println(optMethod(s1, s2));
	}

	private static boolean naiveMethod(String s1, String s2) {
		
		if(s2.length() != s1.length())return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		String s3 = new String(c1);
		String s4 = new String(c2);

		if (s3.equals(s4)) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean optMethod(String s1, String s2) {
		int size = 256;
		int[] count = new int[size];

		if (s1.length() != s2.length())
			return false;
		
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}

		for (int i = 0; i < size; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
