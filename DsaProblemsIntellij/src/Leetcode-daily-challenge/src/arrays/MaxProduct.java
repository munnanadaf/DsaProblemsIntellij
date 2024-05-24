package arrays;

// of nums[i]-1 & nums[j]-1
class MaxProduct {
    public int maxProduct(int[] nums) {
        int secMax = 0;
        int max = nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++){
            if(nums[i]>max){
                secMax = max;
                max = nums[i];
            }else if(nums[i]>secMax)
                secMax = nums[i];
        }
        return (max-1)*(secMax-1);
    }
}