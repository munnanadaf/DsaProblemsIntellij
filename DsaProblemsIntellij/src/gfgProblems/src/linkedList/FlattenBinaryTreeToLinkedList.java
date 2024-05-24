package linkedList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return;
		TreeNode right = root.right;
		if (root.left != null) {
			flatten(root.left);
			TreeNode tmpRight = root.right; // storing rignt node as tmp node
			root.right = root.left; // left will be linked as right node.
			root.left = null; // left will be unlinked

			right = root.right; // cur right, which was left previously
			while (right.right != null) {
				right = right.right; // searching for last right node.(previously left subtree.)
			}
			right.right = tmpRight;
		}
		flatten(right); // repeating same for right sub tree.
	}
}