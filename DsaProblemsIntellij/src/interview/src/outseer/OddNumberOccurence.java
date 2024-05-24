package outseer;

public class OddNumberOccurence {
	public static int oddOccurenceNumber(int arr[]) {
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 8, 1, 2, 3, 8,8};
		System.out.println(oddOccurenceNumber(arr));
	}
}
