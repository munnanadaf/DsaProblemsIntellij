package linkedList;
class NthFromLast
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here	
    	Node fast = head;
    	Node slow = head;
    	
    	while(n != 0){
    	    if(fast == null)
    	        return -1;
    	    fast = fast.next;
    	    n--;
    	}
    	
    	while(fast != null){
    	    slow = slow.next;
    	    fast = fast.next;
    	}
    	return slow != null?slow.data:-1; // when fast will be pointing to null, slow will be pointing to nth node from end
    }
}