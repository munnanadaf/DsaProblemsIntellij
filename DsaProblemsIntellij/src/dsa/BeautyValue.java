package dsa;

public class BeautyValue {
	
	static int MOD = (int)(1e9 + 7);
	
	public static int gcd(int a , int b) {
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(a==b)return a;
		
		if(a>b)
			return gcd(a-b,b);
		return gcd(a,b-a);
	}
	
	
	public static int beautyValue(int N){
		int beauty = 0;
		for (int i = 1; i < N; i++) {
			System.out.println("&&&&&&&&&&&&&&7 "+ i);
			for (int j = i + i; j <= N; j++) {
				System.out.println("gcd i j" + i + " i" + j + "j " + " gcd " + gcd(i, j));
				beauty += gcd(i, j);
			}
		}
		return beauty;
	}
	
	
	public static void main(String[] args) {
		int k = 4;
		System.out.println(beautyValue(k));
	}

}
