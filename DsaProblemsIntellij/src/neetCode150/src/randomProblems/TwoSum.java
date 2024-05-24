package randomProblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int a[] = {2,7,11,15};
//		System.out.println(twoSum(a, 11));
		int j[] = twoSum1(a, 9);
		for(int k:j) {
			System.out.println(k);
		}
	}

	private static boolean twoSum(int a[], int target) {
		Map<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (h.containsKey(target - a[i])) {
				return true;
			} else {
				h.put(a[i], 0);
			}
		}
		return false;
	}
	
	private static int[] twoSum1(int a[], int target) {
		int b[] = new int[2];
		int k = 0;
		Map<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (h.containsKey(target - a[i])) {
				k = i;
			} else {
				h.put(a[i], 0);
			}
		}
		for (int i = 0; i < a.length; i++) {
			if ((target - a[k] == a[i]) && k != i) {
				b[0] = k;
				b[1] = i;
				break;
			}
		}

		return b;
	}

}
