package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class AddOneRowToTree {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth > 1) {
			helper(root, val, depth, 1);
			return root;
		} else {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
	}

	public TreeNode helper(TreeNode root, int val, int depth, int curDepth) {
		if (root == null)
			return null;
		if (curDepth == depth - 1) {
			TreeNode tLeft = root.left;
			TreeNode tRight = root.right;

			root.left = new TreeNode(val);
			root.right = new TreeNode(val);
			root.left.left = tLeft;
			root.right.right = tRight;
			return root;
		}
		root.left = helper(root.left, val, depth, curDepth + 1); // if no change stays as it is, if in next step
																	// changes, introduces intermediate nodes
		root.right = helper(root.right, val, depth, curDepth + 1); // if no change stays as it is, if in next step
																	// changes, introduces intermediate nodes
		return root;
	}
}