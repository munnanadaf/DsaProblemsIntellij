package dummy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RearrangeArrayElementsToFormLargestNumber {
	public static void main(String[] args) {
		String arr[] = { "3", "30", "34", "5", "9" };
//		largest(arr);
		String one = "3";
		String two = "34";
		
		String xy = "3"+"34";
		String yx = "34"+"3";
		System.out.println(xy.compareTo(yx));
		System.out.println(yx.compareTo(xy));
	}

	public static void largest(String[] arr) {

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String xy = o1 + o2;
				String yx = o2 + o1;
				return xy.compareTo(yx) < 0 ? -1 : 1;
			}
		});
		
		for(String s:arr)
			System.out.print(s+"");
		
	}

}
