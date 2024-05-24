package linkedList;

// kth node from beginning & from the end
class SwapLinkedListNodes {
	public ListNode swapNodes(ListNode head, int k) {
		ListNode fast = head;
		ListNode tempPointer = head;
		ListNode slow = head;
		int count = 0;
		while (count < k - 1 && fast.next != null) {
			count++;
			fast = fast.next;
			tempPointer = tempPointer.next;
		}
		ListNode first = fast;
		while (tempPointer.next != null) {
			tempPointer = tempPointer.next;
			slow = slow.next;
		}
		ListNode second = slow;
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
		return head;
	}
}