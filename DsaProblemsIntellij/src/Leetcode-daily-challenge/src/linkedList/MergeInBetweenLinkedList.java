package linkedList;

class MergeInBetweenLinkedList {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode nodeA = list1;
		ListNode listEnd = list2;
		while (listEnd.next != null) {
			listEnd = listEnd.next;
		}
		for (int i = 0; i < a - 1; i++) {
			nodeA = nodeA.next;
		}
		ListNode nodeB = list1;
		for (int j = 0; j <= b; j++) {
			if (nodeB.next != null)
				nodeB = nodeB.next;
		}
		nodeA.next = list2;
		listEnd.next = nodeB;
		return list1;
	}
}