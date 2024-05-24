package linkedList;

class ReorderList {
	public void reorderList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode midNode = reverseList(slow.next);
		slow.next = null;

		ListNode cur = head;

		while (cur != null && midNode != null) {
			ListNode curNext = cur.next;
			cur.next = midNode;
			ListNode minNext = midNode.next;
			midNode.next = curNext;
			cur = curNext;
			midNode = minNext;
		}

	}

	public ListNode reverseList(ListNode node) {
		ListNode cur = node;
		ListNode next, prev = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
}