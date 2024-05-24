package arrays;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int a[] = new int[8];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		int b[] = { 7, 8, 9 };

		mergeTwoSortedArraysIntoFirst(a, 5, b, 3);
		for (int i : a) {
			System.out.print(i + "");
		}
	}

	public static void mergeTwoSortedArraysIntoFirst(int a[], int m, int b[], int n) {
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while (i >= 0) {
			a[k--] = a[i--];
		}
		while (j >= 0) {
			a[k--] = b[j--];
		}
	}

}
