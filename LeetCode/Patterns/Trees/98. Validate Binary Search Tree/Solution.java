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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;

        // node.val must be strictly > low and strictly < high
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        // Left subtree: upper bound becomes node.val
        // Right subtree: lower bound becomes node.val
        return validate(node.left, low, node.val)
            && validate(node.right, node.val, high);
    }
}