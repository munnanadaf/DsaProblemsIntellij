package recursion;

import java.util.ArrayList;

public class PowerSet {
	// Function to return the lexicographically sorted power-set of the string.
	static ArrayList<String> powerSet(String s) {
		// add your code here
		ArrayList<String> res = new ArrayList<>();
		subSet(s, res, "", 0);
		return res;
	}

	public static ArrayList<String> subSet(String s, ArrayList<String> res, String curr, int i) {
		if (i >= s.length()) {
			res.add(curr);
			return res;
		}
		subSet(s, res, curr, i + 1);
		return subSet(s, res, curr + s.charAt(i), i + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(powerSet("abc"));
	}

}