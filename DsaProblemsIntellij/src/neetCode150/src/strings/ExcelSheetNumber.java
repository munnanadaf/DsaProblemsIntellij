package strings;

public class ExcelSheetNumber {

	public static void main(String[] args) {
		String aa = "AB";
		System.out.println(titleToNumber(aa));
	}

	public static int titleToNumber(String columnTitle) {
		int result = 0;
		for (char c : columnTitle.toCharArray()) {
			int d = c - 'A' + 1;
			result = (result * 26) + d;
		}
		return result;
	}
}
