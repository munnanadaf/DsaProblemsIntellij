package searching;


// naive solution has O(n) time
// this approach has O(logn) time
public class CountNoOf1sBinarySortedArray {

	public static int binSearch(int a[], int l, int h, int k) {
		int mid = (l + h) / 2;
		if (a[mid] == k) {
			if (a[mid - 1] != k) {
				return mid;
			} else {
				return binSearch(a, l, mid - 1, k);
			}
		}
		if (a[mid] < k) {
			return binSearch(a, mid + 1, h, k);
		} else if (a[mid] > k) {
			return binSearch(a, l, mid - 1, k);
		} else if (a[mid] != k && l == h) {
			return -1;
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		int a[] = {0,0,0,0,1,1,1,1,1,1,1,1,1,1};
		int j = binSearch(a, 0, a.length-1, 1);
		System.out.println(a.length-j);
	}

}
