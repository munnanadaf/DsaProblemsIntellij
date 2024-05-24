package bitManipulation;

public class OddOccuringNumberArray {
	
	// only 1 odd occuring number
	public static void oddOccuringNumber(int a[]) {
		int xor  = a[0];
		for(int i=1;i<a.length;i++) {
			xor = xor^a[i];
		}
		
		System.out.println(xor+" odd occuring number");
	}
	
	public static void main(String[] args) {
		
		int b[] = {1,1,2,2,3,3,4,5,5};
		oddOccuringNumber(b);
	}

}
