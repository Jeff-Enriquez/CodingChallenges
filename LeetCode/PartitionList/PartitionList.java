/*
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Constraints:
 *      The number of nodes in the list is in the range [0, 200].
 *      -100 <= Node.val <= 100
 *      -200 <= x <= 200
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Helps when first node must be modified
        ListNode falseHead = new ListNode(Integer.MIN_VALUE);
        falseHead.next = head;
        // Keep track of the node before the node where 'val' >= x
        ListNode beforeX = falseHead;
        // Travers through nodes looking for 'beforeX'
        ListNode node = head;
        while(node != null && node.val < x) {
            beforeX = node;
            node = node.next;
        }
        // Need previous node, current node, and beforeX node for swapping
        ListNode prevNode = node;
        node = (node != null) ? node.next : null;
        // Traverse through rest of list
        while(node != null) {
            if(node.val < x) {
                // Swap nodes
                prevNode.next = node.next;
                node.next = beforeX.next;
                beforeX.next = node;
                // Increment beforeX (node of 'val' < x was placed in front of it)
                beforeX = beforeX.next;
                // Get next node
                node = (prevNode.next != null) ? prevNode.next : null;
            } else {
                // Get next node
                prevNode = node;
                node = node.next;
            }
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