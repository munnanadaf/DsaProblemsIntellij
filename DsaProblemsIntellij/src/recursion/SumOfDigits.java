package recursion;

public class SumOfDigits {
	
	public int getSum(int n) {
		if(n==0) {
			return 0;
		}
		
		return getSum(n/10)+n%10;
	}
	
	public static void main(String[] args) {
		SumOfDigits obj = new SumOfDigits();
		System.out.println(obj.getSum(345));
	}

}
