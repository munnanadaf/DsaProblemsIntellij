package strings;

class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		int i = 0;
		int j = 0;
		int tmp1 = 0;
		int tmp2 = 0;
		int m = version1.length();
		int n = version2.length();
		while (i < m && j < n) {
			tmp1 = 0;
			tmp2 = 0;
			while (i < m && version1.charAt(i) != '.')
				tmp1 = tmp1 * 10 + version1.charAt(i++) - '0';
			while (j < n && version2.charAt(j) != '.')
				tmp2 = tmp2 * 10 + version2.charAt(j++) - '0';
			if (tmp1 > tmp2)
				return 1;
			else if (tmp1 < tmp2)
				return -1;
			else {
				i++;
				j++;
			}
		}
		return 0;
	}
}