package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> unVisited = new HashSet<>();
		for (String word : wordList) {
			unVisited.add(word);
		}
		unVisited.remove(beginWord);
		Queue<Pair> bfsQueue = new LinkedList<>();
		bfsQueue.add(new Pair(beginWord, 1));
		while (!bfsQueue.isEmpty()) {
			Pair p = bfsQueue.poll();
			String curStr = p.first;
			int steps = p.second;
			if (curStr.equals(endWord))
				return steps;
			for (int k = 0; k < curStr.length(); k++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] curWord = curStr.toCharArray();
					curWord[k] = ch;
					String newWord = new String(curWord);
					if (unVisited.contains(newWord)) {
						unVisited.remove(newWord);
						bfsQueue.add(new Pair(newWord, steps + 1));
					}
				}
			}
		}
		return 0;

	}
}
class Pair {
	String first;
	int second;
	Pair(String first, int second) {
		this.first = first;
		this.second = second;
	}
}