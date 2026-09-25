/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false); // in-order
        BSTIterator right = new BSTIterator(root, true); // reverse in-order
        
        int l = left.next();
        int r = right.next();
        
        while (l < r) {
            int sum = l + r;
            if (sum == k) return true;
            if (sum < k) l = left.next();
            else r = right.next();
        }
        return false;
    }
}

class BSTIterator {
    private java.util.Stack<TreeNode> stack;
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.stack = new java.util.Stack<>();
        this.reverse = reverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (!reverse) pushAll(node.right); // in-order: go right
        else pushAll(node.left);           // reverse in-order: go left
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = reverse ? node.right : node.left;
        }
    }
}