// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
public class ReverseADoublelyLinkedList {
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 		n = the number of linked list nodes
	 */
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
    	DoublyLinkedListNode prevNode = null;
    	DoublyLinkedListNode currentNode = llist;
    	DoublyLinkedListNode nextNode = llist.next;
    	while(currentNode != null) {
    		currentNode.prev = nextNode;
    		nextNode = currentNode.next;
    		currentNode.next = prevNode;
    		prevNode = currentNode;
    		currentNode = nextNode;
    	}
    	return prevNode;
    }
    
    class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }
}
