/*
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * 
 * Constraints:
 *      The number of nodes in the list is in the range [0, 300].
 *      -100 <= Node.val <= 100
 *      The list is guaranteed to be sorted in ascending order.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        // Helps remove duplicates at beginning of list
        ListNode falseHead = new ListNode(Integer.MAX_VALUE);
        falseHead.next = head;
        // Needed for removing duplicates
        ListNode prevNode = falseHead;
        // Tracks current value
        ListNode currNode = prevNode.next;
        // Checks for duplicate value
        ListNode nextNode = currNode.next;
        // Traverse all nodes
        while(nextNode != null) {
            // Get the current value
            int val = currNode.val;
            boolean isDuplicate = (nextNode.val == val) ? true : false;
            // Skip to node that is not a duplicate
            while(nextNode != null && nextNode.val == val) {
                nextNode = nextNode.next;
            }
            // Remove all duplicate nodes
            if(isDuplicate) {
                prevNode.next = nextNode;
            }
            // Update nodes to check for next possible duplicate in list
            if(!isDuplicate)
                prevNode = (prevNode != null) ? prevNode.next : null;
            currNode = (prevNode != null) ? prevNode.next : null;
            nextNode = (currNode != null) ? currNode.next : null;
        }
        return falseHead.next;
    }
}
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}