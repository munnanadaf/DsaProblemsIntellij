package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class VerticalOrderTraversal {

	class Pair {
		Node node;
		int index;

		public Pair(Node node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	// Function to find the vertical order traversal of Binary Tree.
	ArrayList<Integer> verticalOrder(Node root) {
		// add your code here
		ArrayList<Integer> res = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		if (root == null)
			return res;
		int curIndex = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, curIndex));
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			Pair curPair = q.poll();
			Node curNode = curPair.node;
			int curInd = curPair.index;
			for (int i = 0; i < size; i++) {
				if (curNode != null) {
					if (!map.containsKey(curInd)) {
						map.put(curInd, new ArrayList<>());
					}
					map.get(curInd).add(curNode.data);
					if (minVal < curInd)
						minVal = curInd;
					if (maxVal > curInd)
						maxVal = curInd;
					q.offer(new Pair(curNode.left, curInd - 1));
					q.offer(new Pair(curNode.right, curInd + 1));
				}
			}
		}
		for (int i = minVal; i <= maxVal; i++) {
			res.addAll(map.get(i));
		}
		return res;
	}
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//class Solution {
//    class Pair{
//        TreeNode node;
//        int ind;
//        public Pair(TreeNode node, int ind){
//            this.node = node;
//            this.ind = ind;
//        }
//    }
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(root == null)
//            return res;
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        Queue<Pair> q = new LinkedList<>();
//        q.offer(new Pair(root,0));
//        int minInd = 0;
//        int maxInd = 0;
//
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0;i<size;i++){
//                Pair p = q.poll();
//                TreeNode curNode = p.node;
//                int ind = p.ind;
//                if(curNode != null){
//                    if(!map.containsKey(ind)){
//                        map.put(ind,new ArrayList<>());
//                    }
//                    // System.out.println(curNode.val+" at index "+ind);
//                    map.get(ind).add(curNode.val);
//                    minInd = Math.min(minInd,ind);
//                    maxInd = Math.max(maxInd,ind);
//                    q.offer(new Pair(curNode.left,ind-1));
//                    q.offer(new Pair(curNode.right,ind+1));
//                }
//            }
//        }
//
//        for(int i = minInd;i<=maxInd;i++){
//            res.add(map.get(i));
//        }
//        return res;
//    }
//}