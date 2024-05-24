package arrays;

import java.util.ArrayList;
import java.util.List;

public class MinSwapsForGroupLessThanK {
	public static int minSwaps(int a[],int k) {
		int count = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]<=k) {
				count++;
			}
		}
		int w=0;
		int res=0;
		List<Integer> al = new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			if(i>=count && a[i]>k) {
				al.add(a[i]);
			}else if(a[i]<k){
				al.remove(al.size()-1);
			}
		}
		return count-al.size();
	}
	
	public static void main(String[] args) {
		int a[] = {2,3,4,5,7,7,6,75};
//		System.out.println(minSwaps(a, 5));
		minSwaps(a, 5);
	}

}
