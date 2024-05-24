package trees;

public class LowsetComonAncestorOfBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == q || root == p)
			return root;
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left == null)
			return right; // q,p lies in the same subtree
		if(right == null)
			return left;
		return root;
	}
}
