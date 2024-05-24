package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public static TreeNode sortedArrayToBST(int[] nums, int low, int high) {
		int m = (low + high) / 2;
		if (low > high)
			return null;
		TreeNode node = new TreeNode(nums[m]);
		node.left = sortedArrayToBST(nums, low, m - 1);
		node.right = sortedArrayToBST(nums, m + 1, high);
		return node;
	}
}