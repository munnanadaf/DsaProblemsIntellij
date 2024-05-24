package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveLoopFromLinkedListCycle {
	// Function to remove a loop in the linked list.
	public static void removeLoop(Node head) {
		// code here
		// remove the loop without losing any nodes
		if (head == null || head.next == null)
			return;
		Node tmp = head;
		Node prev = null;
		Set<Node> set = new HashSet<Node>();
		while (tmp != null) {
			if (!set.add(tmp)) {
				prev.next = null;
				return;
			}
			prev = tmp;
			tmp = tmp.next;
		}
	}
}