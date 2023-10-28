// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeTwoSortedLinkedLists {
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) - creates a new linked list (does not modify head1 or head2)
	 * 		n = the total linked nodes in head1 and head2
	 */
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		/* Get the head of the new sorted linked list */
		int smallerNum;
		SinglyLinkedListNode node1 = head1;
		SinglyLinkedListNode node2 = head2;
		if(node1.data < node2.data) {
			smallerNum = node1.data;
			node1 = node1.next;
		} else {
			smallerNum = node2.data;
			node2 = node2.next;
		}
		SinglyLinkedListNode head = new SinglyLinkedListNode(smallerNum);
		SinglyLinkedListNode node = head;
		
		/* Sort the linked lists */
		while(node1 != null && node2 != null) {
			if(node1.data < node2.data) {
				smallerNum = node1.data;
				node1 = node1.next;
			} else {
				smallerNum = node2.data;
				node2 = node2.next;
			}
			SinglyLinkedListNode n = new SinglyLinkedListNode(smallerNum);
			node.next = n;
			node = n;
		}
		/* Any remaining nodes can be added to the end */
		while(node1 == null && node2 != null) {
			SinglyLinkedListNode n = new SinglyLinkedListNode(node2.data);
			node2 = node2.next;
			node.next = n;
			node = n;
		}
		/* Any remaining nodes can be added to the end */
		while(node1 != null && node2 == null) {
			SinglyLinkedListNode n = new SinglyLinkedListNode(node1.data);
			node1 = node1.next;
			node.next = n;
			node = n;
		}
		
		// Return the head of the linked list
		return head;
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
