package linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleStartPosition {
	public ListNode detectCycle(ListNode head) {
		// remove the loop without losing any nodes
		if (head == null)
			return null;
		ListNode tmp = head;
		ListNode prev = null;
		Set<ListNode> set = new HashSet<ListNode>();
		while (set.add(tmp)) {
			prev = tmp;
			if (tmp.next == null)
				return null;
			tmp = tmp.next;
		}
		return tmp;
	}
}