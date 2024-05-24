package linkedList;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null; // breaking the link in the middle.

		ListNode l1 = sortList(head); // heads last node will be prev. i.e half
		ListNode l2 = sortList(slow); // slows first node will be 2nd half first node.
		return merge(l1, l2);
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(); // pointing to dummy node.
		ListNode tmp = res; // temp will be moving forward, we need res to return head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
		}

		// no need to iterate, attach complete list which is remaining.
		if (l1 != null) {
			tmp.next = l1;
		}
		if (l2 != null) {
			tmp.next = l2;
		}

		return res.next; // bcz initially pointing to dummy node;
	}

}
