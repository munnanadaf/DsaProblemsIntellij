package graphs;

import java.util.HashMap;
import java.util.Map;

class MinimumNoOfDayToEatNOranges {
    Map<Integer,Integer> cache = new HashMap<>();
    public int minDays(int n) {
        if(n<=2)
            return n;
        if(cache.containsKey(n))
            return cache.get(n);
        cache.put(n,1+Math.min(n%2+minDays(n/2),n%3+minDays(n/3)));
        return cache.get(n);
    }
}