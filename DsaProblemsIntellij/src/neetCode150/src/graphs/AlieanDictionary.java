package graphs;
//{ Driver Code Starts

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class AlieanDictionary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.next());
		while (t-- > 0) {
			int n = Integer.parseInt(sc.next());
			int k = Integer.parseInt(sc.next());

			String[] words = new String[n];

			for (int i = 0; i < n; i++) {
				words[i] = sc.next();
			}

			AlieanDictionary ob = new AlieanDictionary();
			// System.out.println(T.findOrder(words,k));
			String order = ob.findOrder(words, n, k);
			if (order.length() == 0) {
				System.out.println(0);
				continue;
			}
			String temp[] = new String[n];
			for (int i = 0; i < n; i++)
				temp[i] = words[i];

			Arrays.sort(temp, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					int index1 = 0;
					int index2 = 0;
					for (int i = 0; i < Math.min(a.length(), b.length()) && index1 == index2; i++) {
						index1 = order.indexOf(a.charAt(i));
						index2 = order.indexOf(b.charAt(i));
					}

					if (index1 == index2 && a.length() != b.length()) {
						if (a.length() < b.length())
							return -1;
						else
							return 1;
					}

					if (index1 < index2)
						return -1;
					else
						return 1;

				}
			});

			int flag = 1;
			for (int i = 0; i < n; i++) {
				if (!words[i].equals(temp[i])) {
					flag = 0;
					break;
				}
			}

			System.out.println(flag);
		}
	}

	public String findOrder(String[] dict, int N, int K) {
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			int len = Math.min(dict[i].length(), dict[i + 1].length());
			for (int j = 0; j < len; j++) {
				char c1 = dict[i].charAt(j);
				char c2 = dict[i + 1].charAt(j);
				if (c1 != c2) {
					adjList.get(c1 - 'a').add(c2 - 'a');
					break;
				}
			}
		}

		List<Integer> resList = topo(K, adjList);

		String ans = "";
		for (int it : resList) {
			ans = ans + (char) (it + (int) ('a'));
		}
		return ans;

	}

	public List<Integer> topo(int K, List<List<Integer>> adjList) {
		int inDegree[] = new int[K];
		for (int i = 0; i < K; i++) {
			for (int it : adjList.get(i)) {
				inDegree[it]++;
			}
		}

		Queue<Integer> bfsQueue = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			if (inDegree[i] == 0) {
				bfsQueue.offer(i);
			}
		}

		List<Integer> resList = new ArrayList<>();
		while (!bfsQueue.isEmpty()) {
			int curNode = bfsQueue.poll();
			resList.add(curNode);
			for (int neighbourNode : adjList.get(curNode)) {
				inDegree[neighbourNode]--;
				if (inDegree[neighbourNode] == 0)
					bfsQueue.offer(neighbourNode);
			}
		}

		return resList;
	}

}
