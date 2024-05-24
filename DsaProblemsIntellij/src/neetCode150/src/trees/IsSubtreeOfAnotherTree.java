package trees;

class IsSubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return subRoot == null;
		return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

	}

	public boolean isSameTree(TreeNode root, TreeNode subRoot) {

		if (root == null && subRoot == null)
			return true;
		if (root == null || subRoot == null)
			return false;
		if (root.val != subRoot.val)
			return false;
		return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
	}
}