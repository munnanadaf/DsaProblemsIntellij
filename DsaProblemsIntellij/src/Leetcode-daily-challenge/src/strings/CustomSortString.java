package strings;

import java.util.HashMap;
import java.util.Map;

class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        Map<Character,Integer> freq = new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(char c:order.toCharArray()){
            if(freq.containsKey(c)){
                int n = freq.get(c);
                while(n>0){
                    res.append(c);
                    n--;
                }
                freq.remove(c);
            }
        }

        for(char c:freq.keySet()){
            res.append(String.valueOf(c).repeat(Math.max(0,freq.get(c))));
        }

        return res.toString();
    }
}