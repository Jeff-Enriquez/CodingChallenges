/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) additional memory. O(n) memory is already assummed since this method returns a deep copy of the given parameter.
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // Size is 0
        if(head == null)
            return null;
        // Interweave new nodes with old nodes
        Node currNode = head;
        while(currNode != null) {
            Node copy = new Node(currNode.val);
            copy.next = currNode.next;
            currNode.next = copy;
            currNode = copy.next;
        }
        // Update the 'random' value of the new interweaved nodes
        currNode = head;
        while(currNode != null) {
            currNode.next.random = (currNode.random == null) ? null : currNode.random.next;
            currNode = currNode.next.next;
        }
        // Separate the interweaved nodes and the original node list
        currNode = head;
        Node deepCopyHead = currNode.next;
        Node deepCopyCurrNode = deepCopyHead;
        while(deepCopyCurrNode.next != null) {
            currNode.next = currNode.next.next;
            currNode = currNode.next;
            deepCopyCurrNode.next = deepCopyCurrNode.next.next;
            deepCopyCurrNode = deepCopyCurrNode.next;
        }
        currNode.next = null;
        // Return the head of the deep copy
        return deepCopyHead;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}