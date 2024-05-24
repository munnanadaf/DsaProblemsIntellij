package trees;

public class MirrorTree {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right.left = new TreeNode(4);
		t.right.right = new TreeNode(3);
		System.out.println(isSymmetric(t));

	}

	public static boolean isSymmetric(TreeNode root) {
		return root == null || isMirror(root.left, root.right);
	}

	public static boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null)
			return false;

		if (node1.val != node2.val)
			return false;
		return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
	}
}
