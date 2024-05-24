package arrays;

public class MoveZerosToRight {
	public static void moveZeros(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				int tmp = a[i];

				// initially it swaps with itself if non zero element
				a[i] = a[count];
				a[count] = tmp;
				count++;
				// count keeps track of next non zero element to be placed / total non zero
				// elements
			}
		}
	}
	
	
	public static void main(String[] args) {
		int k[] = {1,2,0,3,5,0,0,5,8};
		moveZeros(k);
		
		for (int i : k) {
			System.out.print(i+" ");
		}
	}
}
