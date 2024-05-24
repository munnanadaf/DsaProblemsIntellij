package trees;
// mirror image
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        invertTree(root.right);
        invertTree(root.left);
        TreeNode curr = root.left;
        root.left = root.right;
        root.right = curr;
        return root;
    }
}