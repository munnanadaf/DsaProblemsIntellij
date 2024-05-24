package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OperationsOnTrees {
	class LockingTree {
		int parent[];
		Map<Integer, Integer> lockMap = new HashMap<>();
		Map<Integer, List<Integer>> childrenMap = new HashMap<>();

		public LockingTree(int[] parent) {
			this.parent = parent;
			int n = parent.length;
			for (int i = 0; i < n; i++) {
				childrenMap.put(i, new ArrayList<>());
			}
			for (int i = 1; i < n; i++) { // for node 1, parent is 0
				childrenMap.get(parent[i]).add(i);
			}
		}

		public boolean lock(int num, int user) {
			if (lockMap.containsKey(num))
				return false;
			lockMap.put(num, user);
			return true;
		}

		public boolean unlock(int num, int user) {
			if (lockMap.containsKey(num) && lockMap.get(num) == user) { // same user is unlocking
				lockMap.remove(num);
				return true;
			}
			return false;
		}

		public boolean upgrade(int num, int user) {
			int orign = num;
			if (lockMap.containsKey(num)) // upgradable node should not be locked
				return false;
			while (parent[num] != -1) {
				if (lockMap.containsKey(parent[num]))
					return false;
				num = parent[num];
			}
			Queue<Integer> q = new LinkedList<>();
			List<Integer> children = childrenMap.get(num);
			if (children != null) {
				for (int cc : children)
					q.offer(cc);
			}

			boolean lock = false;
			while (!q.isEmpty()) {
				int cur = q.poll();
				if (lockMap.get(cur) != null) // any one child should be locked
				{
					lock = true;
					lockMap.remove(cur);
				}
				List<Integer> subChilds = childrenMap.get(cur);
				if (subChilds != null) {
					for (int cc : subChilds)
						q.offer(cc);
				}
			}
			if (!lock)
				return false; // if no child is locked.
			lockMap.put(orign, user);
			return true;
		}
	}
}
