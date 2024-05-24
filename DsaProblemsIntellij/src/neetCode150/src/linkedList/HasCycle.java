package linkedList;

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && slow != null) {
			if (slow.next == null || fast.next == null || fast.next.next == null) {
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}
	
	public boolean hasCycle2(ListNode head) {
		if(head ==  null) return false;
		while(head != null) {
			if(head.val==99999) return true;
			head.val = 99999;
			head = head.next;
		}
		return false;
	}
}
