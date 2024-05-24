package linkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null )return null;
        int countA = 0;
        ListNode nodeA = headA.next;
         while(nodeA != null){
             countA++;
             nodeA = nodeA.next;
         }

         int countB = 0;
        ListNode nodeB = headB.next;
         while(nodeB != null){
             countB++;
             nodeB = nodeB.next;
         }
         while(countA != countB){
             if(countA>countB){
                 headA = headA.next;
                 countA--;
             }
             else{
                 headB = headB.next;
                 countB--;
             }
         }
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;

    }
    
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
}