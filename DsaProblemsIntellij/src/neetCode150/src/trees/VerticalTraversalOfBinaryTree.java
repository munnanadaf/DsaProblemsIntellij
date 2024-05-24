package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// if in same row, same col, more than 1 nodes are there, then only sort them based on values, otherwise, sort row wise.
public class VerticalTraversalOfBinaryTree {

	class Pair {
		int row;
		int col;
		TreeNode node;

		public Pair(TreeNode node, int row, int col) {
			this.node = node;
			this.row = row;
			this.col = col;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Map<Integer, List<Pair>> map = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();
		int minCol = 0;
		int maxCol = 0;
		q.offer(new Pair(root, 0, 0));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int row = p.row;
			int col = p.col;
			TreeNode curNode = p.node;
			minCol = Math.min(minCol, col);
			maxCol = Math.max(maxCol, col);
			if (curNode != null) {
				if (!map.containsKey(col)) {
					map.put(col, new ArrayList<>());
				}
				List<Pair> tmpList = map.get(col);
				tmpList.add(p);
				map.put(col, tmpList);

				q.offer(new Pair(curNode.left, col - 1, row + 1));
				q.offer(new Pair(curNode.right, col + 1, row + 1));
			}
		}

		for (int i = minCol; i <= maxCol; i++) {
			List<Pair> tmpList = map.get(i);
			Collections.sort(tmpList, (a, b) -> {
				if (a.row == b.row)
					return a.node.val - b.node.val;
				else
					return a.row - b.row;
			});

			List<Integer> subRes = new ArrayList<>();
			for (Pair p : tmpList) {
				subRes.add(p.node.val);
			}
			res.add(subRes);
		}
		return res;
	}
}
