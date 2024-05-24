package maths;

class WinnerOfAnArrayGame {
	public int getWinner(int[] arr, int k) {
		int cur = arr[0];
		int win = 0;
// we cant sort & return just the biggest element, it kinds of asks us to determine first element that wins the round. by consecutively winning.
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > cur) {
				cur = arr[i];
				win = 0;
			}
			if (++win == k)
				break;
		}
		return cur;
	}
}