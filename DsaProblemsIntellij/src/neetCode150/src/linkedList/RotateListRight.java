package linkedList;

//  Definition for singly-linked list. 
//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode() {
//	}
//
//	ListNode(int val) {
//		this.val = val;
//	}
//
//	ListNode(int val, ListNode next) {
//		this.val = val;
//		this.next = next;
//	}
//}

public class RotateListRight {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		ListNode t = head;
		int n = 1;
		while (t.next != null) {
			n++;
			t = t.next;
		}

		if (k == n)
			return head;

		k = n - k % n;

		t.next = head;
		while (k != 0) {
			t = t.next;
			k--;
		}

		head = t.next;
		t.next = null;

		return head;

	}
}