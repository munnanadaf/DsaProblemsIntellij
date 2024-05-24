package arrays;

// from sorted array
public class RemoveDuplicates {
	public static int removeDuplicates(int a[]) {
		int res = 1;
		for (int i = 1; i < a.length; i++) {

			// if current i.e ith element and previos included or res-1th elements are
			// different, then copy ith element at res pos otherwise go to next element and
			// copy tha to res pos, if different element
			if (a[i] != a[res - 1]) {
				a[res] = a[i];
				res++;
			}

			// if current and previous res element are different then copying current
			// element at current pos and then incrementing both current and res pos;
		}

		return res;
	}
	
	public static void main(String[] args) {
		int k [] = {1,2,2,4,6,7,7,7};
		int n = removeDuplicates(k);
		
		for(int i=0;i<n;i++) {
			System.out.print(k[i]+" ");
		}
	}
}
