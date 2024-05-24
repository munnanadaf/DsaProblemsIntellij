package linkedList;

public class DeleteNodeWithoutHeadReference {

	public void deleteWithoutHead(Node del) {
		while (del != null) {
			if (del.next != null) {
				del.data = del.next.data;
				del.next = del.next.next; // skipping next, & linking cur to next.next node
			}
			del = null; // if there is no next node, make cur null
		}
	}

}
