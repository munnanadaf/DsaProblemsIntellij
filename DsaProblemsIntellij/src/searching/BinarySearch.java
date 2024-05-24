package searching;

public class BinarySearch {
	public static int binSearch(int a[], int l , int h, int k) {
		int mid = (l+h)/2;
		if(a[mid]<k) {
			return binSearch(a,mid+1,h,k);
		}else if(a[mid]>k) {
			return binSearch(a,l,mid-1,k);
		}
		return mid;
	}
	
	
	public static void main(String[] args) {
		int a[] = {1,4,5,8,30,60,65,100};
		System.out.println(binSearch(a, 0, a.length-1, 65));
	}
}
