/*
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Constraints:
 *      The number of nodes in the tree is in the range [0, 10^4].
 *      -100 <= Node.val <= 100
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the height of the tree
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        // Count the length of the left nodes
        int lcnt = maxDepth(root.left);
        // Count the length of the right nodes
        int rcnt = maxDepth(root.right);
        // Return the max length, +1 for the root node
        return Math.max(lcnt,rcnt)+1;
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