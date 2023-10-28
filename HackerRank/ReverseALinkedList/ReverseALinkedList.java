// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public class ReverseALinkedList {

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 		n = the number of linked lists
	 */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    	SinglyLinkedListNode previousNode = null;
    	SinglyLinkedListNode currentNode = llist;
    	// Swap the pointers of each node
    	while(currentNode != null) {
    		SinglyLinkedListNode nextNode = currentNode.next;
    		currentNode.next = previousNode;
    		previousNode = currentNode;
    		currentNode = nextNode;
    	}
    	return previousNode;
    }

	class SinglyLinkedListNode {
	    public int data;
	    public SinglyLinkedListNode next;
	
	    public SinglyLinkedListNode(int nodeData) {
	        this.data = nodeData;
	        this.next = null;
	    }
	}
}

