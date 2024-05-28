/*
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * Constraints:
 *      The number of nodes in the list is n.
 *      1 <= n <= 500
 *      -500 <= Node.val <= 500
 *      1 <= left <= right <= n
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Number of nodes to swap (including left position)
        int diff = right - left + 1;

        // Create a Node before the head, this helps when the head node is included in the reversal 
        ListNode beforeLeftNode = new ListNode(0);
        beforeLeftNode.next = head;

        // Find the node before the position that needs to be reversed
        // Indexes starts with 1 instead of 0
        for(int i = 1; i < left; i++)
            beforeLeftNode = beforeLeftNode.next;

        // Reverse the nodes from position left to right
        ListNode leftNode = beforeLeftNode.next;
        for(int i = 1; i < diff; i++) {
            // Get the next node within the left to right positions
            ListNode nextNode = leftNode.next;
            // Update the 'leftNode' pointer
            leftNode.next = nextNode.next;
            // Position the 'nextNode' in front of 'beforeLeftNode'
            nextNode.next = beforeLeftNode.next;
            beforeLeftNode.next = nextNode;
        }
        // The head node has been reversed
        if(left == 1)
            return beforeLeftNode.next;
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