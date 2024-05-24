package recursion;

public class Fibonacei {
	public int fib(int n) {
		if(n==0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		return fib(n-1)+fib(n-2);
	}
	
	
	public static void main(String[] args) {
		Fibonacei obj = new Fibonacei();
		obj.fib(8);
	}

}
