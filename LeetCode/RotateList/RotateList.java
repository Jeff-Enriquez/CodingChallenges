/*
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Constraints:
 *      The number of nodes in the list is in the range [0, 500].
 *      -100 <= Node.val <= 100
 *      0 <= k <= 2 * 10^9
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // Not enough nodes to perform rotation
        if(head == null || head.next == null)
            return head;
        // Get size of the list
        int size = 1;
        ListNode node = head;
        for(; node.next != null; size++)
            node = node.next;
        // Save reference to last node
        ListNode lastNode = node;
        // Position of what will be the new head node
        k = size - (k % size);
        // Get the node before the new head node
        node = head;
        for(int i = 1; node != null && i < k; i++)
            node = node.next;
        // Last Node will point to the head
        lastNode.next = head;
        // New head node
        head = node.next;
        // End of list
        node.next = null;
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