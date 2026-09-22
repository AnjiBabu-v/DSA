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
    int maxSum = 0;
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[0] == 1 && right[0] == 1
                && left[3] < node.val && node.val < right[2]) {
            int sum = left[1] + right[1] + node.val;
            int min = Math.min(left[2], node.val);
            int max = Math.max(right[3], node.val);
            maxSum = Math.max(maxSum, sum);
            return new int[]{1, sum, min, max};
        }
        return new int[]{0, 0, 0, 0};
    }

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum;
    }
}