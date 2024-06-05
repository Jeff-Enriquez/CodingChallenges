/*
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 *      LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *      int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *      void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Constraints:
 *      1 <= capacity <= 3000
 *      0 <= key <= 10^4
 *      0 <= value <= 10^5
 *      At most 2 * 10^5 calls will be made to get and put.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(c): c is given capacity
 */
import java.util.*;
class LRUCache {
    final private HashMap<Integer, Node> cache = new HashMap<>();
    final private Node head = new Node(Integer.MIN_VALUE, 0);
    private Node tail = head;
    private int CAPACITY = 0;
    private int size = 0;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
    }
    
    public int get(int key) {
        Node node = cache.getOrDefault(key, new Node(-1, -1));
        if(node.val == -1)
            return -1;
        moveNodeToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = cache.getOrDefault(key, null);
        // Node already exists
        if(node != null) {
            node.val = value;
            moveNodeToTail(node);
        } else {
            if(size == CAPACITY) {
                // Remove oldest node from cache
                cache.remove(head.next.key);
                // Update ref of list
                if(CAPACITY == 1) {
                    head.next = null;
                    tail = head;
                } else if(CAPACITY == 2){
                    head.next = tail;
                    tail.prev = head;
                } else {
                    head.next = head.next.next;
                    head.next.prev = head;
                }
            } else {
                size++;
            }
            // Insert new node at end of list
            node = new Node(key, value);
            tail.next = node;
            node.prev = tail;
            tail = node;
            cache.put(key, node);
        }
    }

    // When existing node is accessed it's moved to the tail end
    private void moveNodeToTail(Node node) {
        // Node is already at end
        if(node == tail)
            return;
        // Remove node from it's place
        node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        // Replace tail with node
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    // Used for debugging
    private void printList() {
        Node list = head;
        System.out.print("List: ");
        while(list.next != null) {
            System.out.print("[" + list.key + "," + list.val + "] -> ");
            list = list.next;
        }
        System.out.println("[" + list.key + "," + list.val + "] -> ");
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val) { 
        this.key = key;
        this.val = val;
    }
}