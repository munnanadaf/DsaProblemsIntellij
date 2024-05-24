package strings;

class IndexOfFirstOccurenceInString {
	public static void main(String[] args) {
		String h = "sadbutsad";
		String needle = "sad";
		System.out.println(strStr(h, needle));
	}

	public static int strStr(String haystack, String needle) {
		int hLen = haystack.length();
		int nLen = needle.length();
		int nIndex = 0;
		for (int i = 0; i < hLen; i++) {
			if (haystack.charAt(i) == needle.charAt(nIndex)) {
				nIndex++;
			} else {
				// next index of previous start index.
				i = i - nIndex;
				nIndex = 0;
			}
			if (nIndex == nLen) {
				return i - nLen + 1;
			}
		}
		return -1;
	}
}