package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CalulateAllPossibleFullBinaryTrees {
    Map<Integer,List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0)
            return new ArrayList<TreeNode>();
        if(n == 1)
            return Arrays.asList(new TreeNode());
        if(memo.containsKey(n))
            return memo.get(n);
        List<TreeNode> res = new ArrayList<>();
        for(int i = 1;i<n;i++){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);

            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(0,l,r); // for left & right subtree root node should be there. // this is where root node is generated in bottom-up manner
                    res.add(root);
                }
            }
        }
        memo.put(n,res);
        return res;
    }
}