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
    public int maxPathSum(TreeNode root) {
     int[] max1=new int[1];
     max1[0]=Integer.MIN_VALUE;
     maxd(root,max1);
     return max1[0];   
    }
    int maxd(TreeNode node,int max[])
    {
        if(node==null)
        {
            return 0;
        }
        int l=Math.max(0,maxd(node.left, max));
        int r=Math.max(0,maxd(node.right, max));
        max[0]=Math.max(max[0],l+r+node.val);
        return Math.max(l,r)+node.val;
    }
}