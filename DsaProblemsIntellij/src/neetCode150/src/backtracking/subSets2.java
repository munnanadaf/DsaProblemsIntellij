package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// input array contains duplicates.
class subSets2 {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort( nums ); //To handle duplicate first we sort the array ( adjacent elements will be similar )
        List<List<Integer>> res = new ArrayList();
        backTracking( 0, nums,res, new ArrayList() );
        return res;
    }
    
    public void backTracking( int index, int[] nums,List<List<Integer>> res, List<Integer> list )
    {
        res.add( new ArrayList(list) );
        for( int i = index;i < nums.length; i++ )
        {
            if( i != index && nums[i] == nums[i-1] ) //skip the duplicates, except for the first time
                continue;
            list.add( nums[i]); //include
            backTracking(i+1,nums,res,list); //explore
            list.remove( list.size()-1);//backtrack, remove the element
        }
    }
}