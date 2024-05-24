package trees;
// trim bst nodes if node values are out bound for -> [low,high], including i.e node.val>= low && node.val <=high are allowed

public class TrimBST {
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return root;
		if (root.val < low)
			return trimBST(root.right, low, high); // skipping current node, instead of returning curr node we are
													// returning child node, value not in range
		if (root.val > high)
			return trimBST(root.left, low, high); // skipping current node, instead of returning curr node, we are
													// returning child node, value not in range
		root.left = trimBST(root.left, low, high); // assigning same node & moving forward, value is in range
		root.right = trimBST(root.right, low, high); // assigning same node & moving forward, value is in range
		return root;
	}
}
