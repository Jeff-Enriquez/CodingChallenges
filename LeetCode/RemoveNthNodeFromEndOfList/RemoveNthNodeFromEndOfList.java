/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Constraints:
 *      The number of nodes in the list is sz.
 *      1 <= sz <= 30
 *      0 <= Node.val <= 100
 *      1 <= n <= sz
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Get size of the ListNodes
        int size = 0;
        ListNode node = head;
        for(size = 1; node.next != null; size++)
            node = node.next;
        // If the size is 1
        if(size == 1)
            return null;
        // Get the position of nth element
        n = size - n;
        // Head element is removed
        if(n == 0)
            return head.next;
        // Get to the node before the node that is to be removed
        node = head;
        for(int i = 1; i < n; i++)
            node = node.next;
        // Remove the nth node
        if(node.next != null)
            node.next = node.next.next;
        // Return the head
        return head;
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