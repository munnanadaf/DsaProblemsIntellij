package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationOfPhoneNumber {
	Map<Character, String> digitsToChar;
	public List<String> letterCombinations(String digits) {
        digitsToChar = new HashMap<>() {
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return new ArrayList<>();
		backTrack(digits, res, "", 0);
		return res;
	}
	public void backTrack(String digits, List<String> res, String curString, int ind) {
		if (digits.length() == curString.length()) {
			res.add(curString);
			return;
		}
		if (ind >= digits.length())
			return;
		else {
			String charString = digitsToChar.get(digits.charAt(ind));
			for (char c : charString.toCharArray()) {
				backTrack(digits, res, curString + c, ind + 1);
			}
		}
	}
}