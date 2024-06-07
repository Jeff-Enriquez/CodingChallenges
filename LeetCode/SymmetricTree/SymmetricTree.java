/*
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * Solve it both recursively and iteratively.
 * 
 * Constraints:
 *      The number of nodes in the tree is in the range [1, 1000].
 *      -100 <= Node.val <= 100
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the height of the tree
 */
import java.util.*;
public class SymmetricTree {
    // Iterative solution
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        // Create stack for traversing tree
        Deque<TreeNode> nodes = new ArrayDeque<>();
        // Check the next nodes before adding to the stack
        if(root.left == null || root.right == null)
            return root.left == root.right;
        nodes.addFirst(root.left);
        nodes.addFirst(root.right);
        // Traverse the tree
        TreeNode node1, node2;
        while(nodes.size() > 0) {
            // Get the next nodes
            node1 = nodes.removeFirst();
            node2 = nodes.removeFirst();
            if(node1.val != node2.val)
                return false;
            // Check the side 1 before adding to the stack
            if(node1.left == null || node2.right == null) {
                if(node1.left != node2.right)
                    return false;
            } else {
                nodes.addFirst(node1.left);
                nodes.addFirst(node2.right);
            }
            // Check the side 2 before adding to the stack
            if(node1.right == null || node2.left == null) {
                if(node1.right != node2.left)
                    return false;
            } else {
                nodes.addFirst(node1.right);
                nodes.addFirst(node2.left);
            }
        }
        return true;
    }
    // Recursive solution
    public boolean isSymmetricRecursiveSolution(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null || node2 == null)
            return node1 == node2;
        if(node1.val != node2.val)
            return false;
        if(!isSymmetric(node1.right, node2.left))
            return false;
        return isSymmetric(node1.left, node2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}