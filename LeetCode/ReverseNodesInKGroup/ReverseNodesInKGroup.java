/*
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * 
 * Constraints:
 *      The number of nodes in the list is n.
 *      1 <= k <= n <= 5000
 *      0 <= Node.val <= 1000
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;
        
        // Create false head so true head can be returned
        ListNode falseHead = new ListNode(0);
        falseHead.next = head;
        // Get the size of the total number of ListNodes
        int listSize = 1;
        ListNode node = head;
        while((node = node.next) != null)
            listSize++;


        // This helps with reversal
        ListNode beforeNode, nextNode;
        // Reset node
        node = falseHead;
        while(listSize >= k) {
            // Get the nodes for reversal
            beforeNode = node;
            node = node.next;
            // Reverse nodes in k-group
            for(int i = 0; i < k - 1; i++) {
                nextNode = node.next;
                node.next = nextNode.next;
                nextNode.next = beforeNode.next;
                beforeNode.next = nextNode;
            }
            listSize -= k;
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