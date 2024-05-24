package arrays;

public class RemoveDuplicateElements {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 4, 6, 7, 8 };

		int newSize = removeDuplicateElements(arr, arr.length);

		for (int i = 0; i < newSize; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("first call over");

		removeDuplicateElements1(arr, arr.length);
	}

	public static int removeDuplicateElements(int a[], int n) {
		if (n == 0 || n == 1)
			return n;

		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[i + 1]) {
				a[j++] = a[i];
			}
		}
//		adding last element(nth), above loop considers n-1 nth elements only
		a[j++] = a[n - 1];
//		here j is new size, i.e last element index.
		return j;
	}

	public static void removeDuplicateElements1(int a[], int n) {
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[i + 1]) {
				a[j++] = a[i];
			}
		}
//		adding last element(nth), above loop considers n-1 nth elements only
		a[j++] = a[n - 1];

//		here j is new size, i.e last element index.
		for (int i = 0; i < j; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
