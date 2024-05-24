package slidingWindow;

import java.util.HashMap;
import java.util.Map;

// two baskets, only 2 types of fruits are allowd.
class FruitsIntoTheBaskets {
	public int totalFruit(int[] fruits) {
		int n = fruits.length;
		int sum = 0;
		Map<Integer, Integer> count = new HashMap<>();
		for (int l = 0, r = 0; r < n; r++) {
			count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
			while (count.size() > 2) {
				count.put(fruits[l], count.get(fruits[l]) - 1);
				// only if the value becomes 0.
				count.remove(fruits[l], 0);
				++l;
			}
			sum = Math.max(sum, r - l + 1);
		}
		return sum;
	}
}