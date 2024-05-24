package binarySearch;

class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int start = 0;
		int end = letters.length;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (letters[mid] > target)
				end = mid;
			else
				start = mid + 1;
		}
		return letters[start % letters.length];
	}
}