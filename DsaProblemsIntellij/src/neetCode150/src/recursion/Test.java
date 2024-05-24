package recursion;

public class Test {
	public static void main(String[] args) {
		int steps = 1,n=6;
		int count =0;
		while(steps<n) {
			steps = steps*2;
			count++;
		}
		
		System.out.println(count-1);
		
		
	}
}
