package hackerrank;

public class InsertNodeAtPosition {
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 		n = number of linked nodes
	 */
	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		// Create the new node
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		// If position is 0 then the new node is the head
		if(position == 0) {
			node.next = llist;
			return node;
		}
		
		// Get the nodeBefore and nodeAfter the insertion position
		SinglyLinkedListNode nodeBeforeInsert = llist;
		SinglyLinkedListNode nodeAfterInsert = null;
		
		int idx = 0;
		// Iterate through the linked list until we get to the new node position
		while(++idx <= position - 1 && nodeBeforeInsert.next != null)
			nodeBeforeInsert = nodeBeforeInsert.next;
		
		// Set the nodeAfterInsertion value
		nodeAfterInsert = nodeBeforeInsert.next;
		
		// If the position is greater than number of linked nodes
		if(nodeAfterInsert == null && position - idx > 1)
			throw new IllegalArgumentException("Cannot insert a node at position " + position + ". The size of the linked list is " + (idx + 1) + ".");
		
		// Insert the new node in the linked list
		nodeBeforeInsert.next = node;
		node.next = nodeAfterInsert;
		
		// Return the head of the linked list
		return llist;
    }
	
	static class SinglyLinkedListNode {
	    public int data;
	    public SinglyLinkedListNode next;

	    public SinglyLinkedListNode(int nodeData) {
	        this.data = nodeData;
	        this.next = null;
	    }
	}
}
