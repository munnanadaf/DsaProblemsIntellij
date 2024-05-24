package linkedList;

class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode resultList = lists[0];
		for (int i = 1; i < lists.length; i++) {
			resultList = mergeTwoLists(resultList, lists[i]);
		}
		return resultList;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
}