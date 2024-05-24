package searching;

public class SearchInRotatedSortedArray {
	public static int search(int a[], int n, int x) {
		int l = 0, h = n - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			System.out.println("mid "+m+" a[m] "+a[m]);
			if (a[m] == x) {
				return m;
			}
			if (a[l] < a[m]) {
				if (x >= a[l] && x < a[m]) {
					h = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				if (x > a[m] && x <= a[h]) {
					l = m + 1;
				} else
					h = m - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
			int a[]  = {12,22,43,64,3,4,6,8,11};
			System.out.println(search(a, a.length, 6));
	}
}
