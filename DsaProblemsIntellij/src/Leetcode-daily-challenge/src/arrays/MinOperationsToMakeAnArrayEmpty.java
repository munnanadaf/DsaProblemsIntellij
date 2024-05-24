package arrays;

import java.util.HashMap;
import java.util.Map;


// 1. for two equal elements count is 1
// 2. for three equal elements is 1 // only allowed operations
class MinOperationsToMakeAnArrayEmpty {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        int res = 0;
        for(int num:nums)
            freq.put(num,freq.getOrDefault(num,0)+1);
        for(int num:freq.values()){
            if(num == 1)
                return -1;
            res = res+num/3;
            if(num%3 != 0) // not divisible 3 case. divisible by 2 // didnt come by intuition
                res++;
        }
        return res;
    }
}