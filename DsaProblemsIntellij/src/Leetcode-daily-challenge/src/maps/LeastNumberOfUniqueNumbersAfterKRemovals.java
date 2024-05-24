package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class LeastNumberOfUniqueNumbersAfterKRemovals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
//        int n = arr.length;
//        Map<Integer,Integer> freq = new HashMap<>();
//        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
//        for(int num:arr){
//            freq.put(num,freq.getOrDefault(num,0)+1);
//        }
//
//        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
//            pq.add(new int[]{entry.getKey(),entry.getValue()});
//        }
//
//        while(!pq.isEmpty() && k>0){
//            int a[] = pq.poll();
//            if(a[1]==1){ // count
//                freq.remove(a[0]);
//            }else{
//            	int newVal = a[1]-1;
//                freq.put(a[0],newVal);
//                pq.add(new int[] {a[0],newVal}); // re arranging pq
//            }
//            k--;
//        }
//
//        return freq.size();
        
        
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        PriorityQueue<Integer> pq = new PriorityQueue<>(count.values()); // we only care about, minHeap (occurence of a number)
        while (k > 0)
            k -= pq.poll(); // removing total least occurence from k.
        return k < 0 ? pq.size() + 1 : pq.size();       

    }
    
    public static void main(String[] args) {
		int a[] = {2,1,1,3,3,3};
		System.out.println(findLeastNumOfUniqueInts(a, 3));
	}
}