/*
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * Constraints:
 *      The number of nodes in both lists is in the range [0, 50].
 *      -100 <= Node.val <= 100
 *      Both list1 and list2 are sorted in non-decreasing order.
 * 
 * Time Complexity: O(l1 + l2)
 * Space Complexity: O(1), no new list is created. References of list1 and list2 are updated to form a single combined list. 
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        // Both lists contain nodes, the head will be the list that starts with a smaller value
        if(list1 != null && list2 != null)
            if(list1.val < list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }
        // If only list1 exists, then return list1
        else if(list1 != null)
            return list1;
        // If only list2 exists, then return list2
        else if(list2 != null)
            return list2;
        // If no list exists, then return null
        else
            return null;
        // Track the position of the current node
        ListNode currNode = head;
        // Iterate through all nodes of each list
        while(true) {
            // Both lists still contain nodes
            if(list1 != null && list2 != null) {
                // Update the reference to point to the next smallest node
                if(list1.val < list2.val) {
                    currNode.next = list1;
                    currNode = currNode.next;
                    list1 = list1.next;
                } else {
                    currNode.next = list2;
                    currNode = currNode.next;
                    list2 = list2.next;
                }
            } 
            // Only list1 remains
            else if(list1 != null) {
                currNode.next = list1;
                return head;
            } 
            // Only list2 remains
            else if(list2 != null) {
                currNode.next = list2;
                return head;
            } 
            // No list remains
            else {
                return head;
            }
        }
    }
}
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
