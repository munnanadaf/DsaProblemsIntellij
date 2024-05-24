package bitManipulation;

public class countSetBitsOfN {
	// time complexity theta(total bits in n)
	//m1
	public static void setBits(int n) {
		int res = 0;
		while (n > 0) {
			if (n % 2 != 0) {
				res++;
			}
			n = n / 2;
		}
		System.out.println("set bits " + res);

	}

	//m2
	public static void setBits2(int n) {

		//
		int res2 = 0;

		while (n > 0) {
			if ((n & 1) == 1) {
				res2++;
			}
			n = n >> 1;
		}
		System.out.println("set bits " + res2);
	}

	
	// faster method
	
	public static void setBits4(int n) {
		int res4 =0;
		while(n>0) {
			System.out.println("number "+n);
			n= n&(n-1);
			res4++;
		}
		System.out.println("set bits4 method "+res4);
	}

	public static void main(String[] args) {
//		setBits(5);
		setBits4(3);
	}
}
