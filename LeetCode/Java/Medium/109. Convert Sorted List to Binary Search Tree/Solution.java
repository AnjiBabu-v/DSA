/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) { size++; node = node.next; }
        current = head;
        return build(0, size - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;

        TreeNode root = new TreeNode();
        root.left = build(lo, mid - 1);
        root.val = current.val;
        current = current.next;

        root.right = build(mid + 1, hi);
        return root;
    }
}