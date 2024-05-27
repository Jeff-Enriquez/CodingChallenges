/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Constraints:
 *      The number of nodes in each linked list is in the range [1, 100].
 *      0 <= Node.val <= 9
 *      It is guaranteed that the list represents a number that does not have leading zeros.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Add the two nodes
        int value = l1.val + l2.val;
        // If the value is greater than 10 you will have to carry over 1 to the next place value
        int carryOver = value >= 10 ? 1 : 0;
        // The remaining value after carrying over the 1
        value = value >= 10 ? value % 10 : value;
        // Instantiate the head of the list
        ListNode head = new ListNode(value);
        // Instantiate the tail of the list
        ListNode tail = head;
        // Get the next values of the list nodes
        l1 = l1.next;
        l2 = l2.next;
        // Continue while nodes exists
        while(l1 != null || l2 != null) {
            // Add the previous carryOver to the next value (placeholder)
            value = carryOver;
            // Add the value of l1
            if(l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            // Add the value of l2
            if(l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            // If the value is greater than 10 you will have to carry over 1 to the next place value
            carryOver = value >= 10 ? 1 : 0;
            // The remaining value after carrying over the 1
            value = value >= 10 ? value % 10 : value;
            // Add the next node
            tail.next = new ListNode(value);
            // Update the tail
            tail = tail.next;
        }
        // If there is a remainder, add it as a node
        if(carryOver > 0)
            tail.next = new ListNode(carryOver);
        // Return the head
        return head;
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
