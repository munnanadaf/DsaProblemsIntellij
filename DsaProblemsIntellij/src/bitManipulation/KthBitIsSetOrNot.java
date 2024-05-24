package bitManipulation;

public class KthBitIsSetOrNot {
	
	
	// naive method
	public static boolean setOrNot(int n, int k) {
		if((n&(1<<(k-1)))!= 0) {
			return true;
		}
		return false;
	}
	
	//method 2
	public static boolean setOrNot2(int n, int k) {
		if(((n>>(k-1))&1)!= 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("method 1 "+setOrNot(5, 3));
		System.out.println("method 2 "+setOrNot(8, 3));
	}
	

}
