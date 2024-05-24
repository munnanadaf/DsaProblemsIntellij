package trees;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class EvaluateBooleanTree {
    public boolean evaluateTree(TreeNode root) {
        return helpEvaluate(root);
    }

    public boolean helpEvaluate(TreeNode root){
        if(root == null || root.val == 0)
            return false;
        if(root.val == 1)
            return true;
        if(root.val == 2)
            return helpEvaluate(root.left) || helpEvaluate(root.right);
        else
            return helpEvaluate(root.left) && helpEvaluate(root.right);
    }
}