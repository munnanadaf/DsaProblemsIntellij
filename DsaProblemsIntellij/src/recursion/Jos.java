package recursion;

public class Jos {
public static void main(String[] args) {
	System.out.println(jos(5, 2) +" survivour");
}

public static int jos(int n, int k) {
	if(n==1)return 0;
	System.out.println(" nnnnnnnnnnnnnnn "+n);
	int jj = (jos(n-1,k)+k)%n;
	System.out.println("returned n "+jj);
	return jj;
}
}
