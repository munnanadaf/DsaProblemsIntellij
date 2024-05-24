package trees;

import java.util.ArrayList;
import java.util.List;

class RightSideViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        rightSideView(root,res,0);
        return res;
    }

    public void rightSideView(TreeNode root, List<Integer> res, int level){
        if(root == null) return;
        if(res.size()==level){
            res.add(root.val);
        }
        rightSideView(root.right,res,level+1);
        rightSideView(root.left,res,level+1);
    }
}