package arrays;

public class BigDifferenceBetween2Elements {

	public static int bigDifference1(int a[]) {
		int res = a[1] - a[0];
		int minValue = a[0];
		for (int i = 1; i < a.length; i++) {
			res = Math.max(res, a[i] - minValue);
			minValue = Math.min(minValue, a[i]);
		}
		return res;
	}
	
	public static int bigDifference2(int k[] ){
		int h = k[0],l=k[0];
		for(int i=0;i<k.length;i++) {
			if(k[i]<l)
				l=k[i];
			if(k[i]>h)
				h=k[i];
		}
		return h-l;
	}
	
	
	public static void main(String[] args) {
		int a[] = {2,4,7,8,9,3,6,98,9,67};
		System.out.println("1st "+bigDifference1(a));
		System.out.println("2nd "+bigDifference2(a));
	}

}
