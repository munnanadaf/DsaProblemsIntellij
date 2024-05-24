package arrays;

import java.util.HashMap;
import java.util.Map.Entry;

public class MaximumOccuredIntegerInNRange {
	static int maxOccurredInt(int l[], int r[]) {
		int res = 0;
		int min = l[0];
		int max = r[0];
		for (int i = 1; i < l.length; i++) {
			min = Math.min(l[i], min);
			max = Math.max(r[i], max);
//			System.out.print(l[i]+" min max "+r[i]);
		}
		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i = min; i <= max; i++) {
			h.put(i, 0);
		}
		int i = 0;
		int maxOccurence = 0;
		int key = 0;
		while (i < l.length) {
			for (Entry<Integer, Integer> e : h.entrySet()) {
				if (e.getKey() >= l[i] && e.getKey() <= r[i]) {
					h.replace(e.getKey(), e.getValue() + 1);
				}
				if(!(maxOccurence<=e.getValue())) {
					key = e.getKey();
					maxOccurence = e.getValue();
				}
			}
			i++;
		}
		return key;
	}

	public static void main(String[] args) {
		int l[] = { 1, 3, 4, 5 };
		int r[] = { 3, 5, 7, 9 };
		System.out.println(maxOccurredInt(l, r) + " *****************");

	}

}
