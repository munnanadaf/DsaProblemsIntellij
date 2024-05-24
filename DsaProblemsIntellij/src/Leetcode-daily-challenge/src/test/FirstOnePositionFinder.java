package test;

public class FirstOnePositionFinder {
	public int findFirstOnePosition(int[] stream) {
		int low = 0;
		int high = 1;
		int pos = -1;

		while (stream[high] == 0) {
			low = high;
			high *= 2;
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (stream[mid] == 1) {
				pos = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return pos;
	}

	public static void main(String[] args) {
		FirstOnePositionFinder finder = new FirstOnePositionFinder();
		int[] stream1 = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 };
		int[] stream2 = { 0, 1, 1, 1, 1, 1, 1 };
		int[] stream3 = { 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(finder.findFirstOnePosition(stream1)); // Output: 7
		System.out.println(finder.findFirstOnePosition(stream2)); // Output: 1
		System.out.println(finder.findFirstOnePosition(stream3)); // Output: 0
	}
}
