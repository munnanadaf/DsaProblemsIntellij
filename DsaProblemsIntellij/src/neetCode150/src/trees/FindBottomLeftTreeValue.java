package trees;

public class FindBottomLeftTreeValue {
	int ans = 0;
	int h = 0;

	public int findBottomLeftTreeValue(TreeNode root) {
		helpFind(root, 1); // initial depth for level 0 is 1;
		return ans;
	}

	public void helpFind(TreeNode root, int depth) {
		if (h < depth) // if first element for that height
		{
			ans = root.val;
			h = depth; // wont allow right element be returned as ans
		}
		if (root.left != null)
			helpFind(root.left, depth + 1);
		if (root.right != null)
			helpFind(root.right, depth + 1);
	}
}
