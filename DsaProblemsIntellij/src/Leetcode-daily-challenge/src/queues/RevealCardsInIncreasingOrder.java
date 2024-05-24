package queues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class RevealCardsInIncreasingOrder {
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		int n = deck.length;
		int[] result = new int[n];
		Deque<Integer> indices = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			indices.add(i);
		}
		for (int card : deck) {
			int ind = indices.poll();
			result[ind] = card;
			if (!indices.isEmpty()) {
				indices.add(indices.poll());
			}
		}

		return result;
	}
}