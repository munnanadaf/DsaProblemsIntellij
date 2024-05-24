package linkedList;

public class InsertionSortLinkedList {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0); // fake head
		ListNode prev = dummy;
		while (head != null) {
			ListNode tmp = head.next;
			if (prev.val > head.val)
				prev = dummy; // traversing from beginning, resetting
			while (prev.next != null && prev.next.val < head.val) {
				prev = prev.next;
			}
			head.next = prev.next; // making prev's next as head's next;
			prev.next = head; // inserting head in between prev & its next
			head = tmp; // moving head to next node, which is stored in tmp
		}
		return dummy.next;
	}
}
