package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class SmallestStringFromLeaf {
	public String smallestFromLeaf(TreeNode root) {
		StringBuilder smallest = new StringBuilder();
		dfs(root, new StringBuilder(), smallest);
		return smallest.toString();

	}

	public void dfs(TreeNode node, StringBuilder current, StringBuilder smallest) {
		if (node == null)
			return;
		current.append((char) ('a' + node.val));
		if (node.left == null && node.right == null) {
			String str = current.reverse().toString();
			if (smallest.length() == 0 || str.compareTo(smallest.toString()) < 0) {
				smallest.setLength(0);
				smallest.append(str);
			}
			current.reverse(); // backtrack by reversing again
		}
		dfs(node.left, current, smallest);
		dfs(node.right, current, smallest);

		//
		current.setLength(current.length() - 1); // backtrack, remove last added char
	}
}