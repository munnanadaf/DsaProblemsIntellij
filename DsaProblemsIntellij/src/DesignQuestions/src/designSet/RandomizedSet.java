package designSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Insert Delete GetRandom O(1)
class RandomizedSet {

	Map<Integer, Integer> indexMap;
	List<Integer> randomSet;
	Random random;

	public RandomizedSet() {
		indexMap = new HashMap<>();
		randomSet = new ArrayList<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (indexMap.containsKey(val))
			return false;
		else {
			indexMap.put(val, randomSet.size());
			randomSet.add(val);
			return true;
		}
	}

	public boolean remove(int val) {
		if (!indexMap.containsKey(val))
			return false;
		else {
			int ind = indexMap.get(val);
			int lastInd = randomSet.size() - 1;
			if (ind != lastInd) {
				int lastVal = randomSet.get(lastInd);
				randomSet.set(ind, lastVal);
				indexMap.put(lastVal, ind);
			}
			randomSet.remove(lastInd);
			indexMap.remove(val);
			return true;
		}
	}

	public int getRandom() {
		int r = random.nextInt(randomSet.size());
		return randomSet.get(r);

	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */