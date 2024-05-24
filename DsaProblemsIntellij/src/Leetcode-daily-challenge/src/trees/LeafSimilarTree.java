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
class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder list1 = new StringBuilder();
        StringBuilder list2 = new StringBuilder();
        findLeaves(root1,list1);
        findLeaves(root2,list2);
        return list1.toString().equals(list2.toString());
    }

    public void findLeaves(TreeNode root,StringBuilder list){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            list.append(root.val+"#");
            // It is necessary to add # between values to differentiate between 12 3 and 1 23
        findLeaves(root.left,list);
        findLeaves(root.right,list);
    }
}