package trees;

import java.util.ArrayList;
import java.util.List;

class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root,res);
        return res;
    }

    public static void postOrder(TreeNode root, List<Integer> res){
        if(root != null){
            postOrder(root.left,res);
            postOrder(root.right,res);
            res.add(root.val);
        }
    }
}