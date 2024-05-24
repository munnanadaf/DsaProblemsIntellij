package trees;

public class ConstructStringFromTree {
	public String tree2String(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}

	public void helper(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) { // leaf node case
			sb.append(root.val);
			return;
		}
		sb.append(root.val); // first append value;
		sb.append('(');
		helper(root.left, sb);
		sb.append(')');
		if (root.right != null) {
			sb.append('(');
			helper(root.right, sb);
			sb.append(')');
		}
	}
}
