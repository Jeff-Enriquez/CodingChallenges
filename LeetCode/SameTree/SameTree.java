/*
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * 
 * Constraints:
 *      The number of nodes in both trees is in the range [0, 100].
 *      -10^4 <= Node.val <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the height of the tree
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return p == q;
        if(p.val != q.val)
            return false;
        if(!isSameTree(p.left, q.left))
            return false;
        if(!isSameTree(p.right, q.right))
            return false;
        return true;
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