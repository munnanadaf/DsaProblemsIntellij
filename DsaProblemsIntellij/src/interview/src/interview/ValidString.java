package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ValidString {
	public static void main(String[] args) {
		String str = new String("aaaaabbb");
		System.out.println(isValidString(str));
	}

	public static boolean isValidString(String str) {

		if (str == null || str.length() == 0)
			return true;

		Map<Character, Integer> charMap = new HashMap<>();
		for (char c : str.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}

		char prevCountChar = str.charAt(0);
		int prevCount = charMap.get(prevCountChar);

		for (Entry<Character, Integer> entry : charMap.entrySet()) {
			if (entry.getValue() != prevCount)
				return false;
		}

		return true;
	}
}
