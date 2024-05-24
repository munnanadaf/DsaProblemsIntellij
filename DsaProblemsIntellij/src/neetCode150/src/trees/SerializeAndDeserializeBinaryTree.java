package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				sb.append(node.val + " ");
				q.offer(node.left);
				q.offer(node.right);
			} else
				sb.append("# ");
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;
		String dataArr[] = data.split(" ");
		Queue<TreeNode> dq = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
		dq.offer(root);
		for (int i = 1; i < dataArr.length; i++) {
			TreeNode temp = dq.poll();
			if (!dataArr[i].equals("#")) {
				TreeNode left = new TreeNode(Integer.parseInt(dataArr[i]));
				temp.left = left;
				dq.offer(left);
			}
			if (!dataArr[++i].equals("#")) {
				TreeNode right = new TreeNode(Integer.parseInt(dataArr[i]));
				temp.right = right;
				dq.offer(right);
			}
		}
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));