package arrays;

// even if current elem<lastGreatest.
// replace last element with -1
class ReplaceElementsWithItsRightGreatestElements {
	public int[] replaceElements(int[] arr) {
		int n = arr.length;
		int last = arr[n - 1];
		arr[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] < last) {
				arr[i] = last;
			} else {
				int temp = last;
				last = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}
}