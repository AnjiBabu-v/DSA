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
    private List<Integer> modes = new ArrayList<>();
    private int prevCount = 0;   
    private int maxCount = 0;   
    private Integer prevVal = null;

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (prevVal != null && node.val == prevVal) {
            prevCount++;
        } else {
            prevCount = 1;
            prevVal = node.val;
        }

        if (prevCount > maxCount) {
            maxCount = prevCount;
            modes.clear();       
            modes.add(node.val);
        } else if (prevCount == maxCount) {
            modes.add(node.val);    
        }

        inorder(node.right);
    }
}