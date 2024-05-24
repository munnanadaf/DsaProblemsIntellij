package linkedList;

public class DeleteListNode {
	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(5);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(9);

		deleteNode(node.next);
		ListNode.printNode(node);
	}

	public static void deleteNode(ListNode node) {
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        
        node.val = node.next.val; 
        node.next = null;
    }

}
