package linkedList;

class DeleteDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode tmp = head;
		while (tmp != null && tmp.next != null) {
			while (tmp.next != null && tmp.val == tmp.next.val) {
				tmp.next = tmp.next.next;
			}
			tmp = tmp.next;
		}
		return head;
	}
}