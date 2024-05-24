package arrays;

public class MaxConsecutiveOnes {
	public static int maxConsecutiveOnes(int a[] ){
		int cur = 0 , res =0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=1) {
				cur = 0;
			}
			else {
				cur++;
				res = Math.max(res, cur);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
	}

}
