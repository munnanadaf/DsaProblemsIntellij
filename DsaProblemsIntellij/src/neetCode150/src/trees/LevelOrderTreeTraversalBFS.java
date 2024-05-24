package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class LevelOrderTreeTraversalBFS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(8);

		for (List<Integer> string : levelOrder(root)) {
			for (int i : string) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			List<Integer> temp1 = new ArrayList<>();
			int size = q.size();

			for (int i = 0; i < size; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				temp1.add(q.poll().val);
			}
			res.add(temp1);
		}

		return res;

	}
}