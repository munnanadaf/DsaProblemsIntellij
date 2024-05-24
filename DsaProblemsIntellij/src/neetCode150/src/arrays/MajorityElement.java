package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
	public static void main(String[] args) {
		int a[] = { 3, 3, 4 };
		System.out.println(majorityElement(a));
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> keys = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			keys.put(nums[i], (keys.getOrDefault(nums[i], 0)) + 1);
		}

		int maxCount = 0;
		int maxNumber = 0;
		for (Map.Entry<Integer, Integer> entry : keys.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxNumber = entry.getKey();
			}
		}
		return maxNumber;
	}
	
	 public int majorityElement1(int[] num) {

	        int major=num[0], count = 1;
	        for(int i=1; i<num.length;i++){
//	            if at some point count has become zero make current element as majority element
	        	if(count==0){
	                count++;
	                major=num[i];
	            }
//	        	if current element is same as major element increase the count
	            else if(major==num[i]){
	                count++;
	            }
	            else
	            	count--;
	            
	        }
	        return major;
	    }
}
