package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeStrings {
	public static Map<String, String> codeMap = new HashMap<>();

	public static String encode(String longUrl) {
		String randomString = generateRandom(6);
		String template = "http://tinyurl.com/";
		String res = template + randomString;
		codeMap.put(res, longUrl);
		return res;
	}

	public static String decode(String shortUrl) {
		return codeMap.get(shortUrl);
	}

	public static String generateRandom(int length) {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(s.length());
			sb.append(s.charAt(randomIndex));
		}
		return sb.toString();
	}
}