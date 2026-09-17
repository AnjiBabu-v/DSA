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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kNode = kNode.next;
                if (kNode == null) {
                    return dummy.next; 
                }
            }
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = groupStart;
            for (int i = 1; i < k; i++) {
                groupEnd = groupEnd.next;
            }
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;
            ListNode reversedHead = reverseList(groupStart);
            ListNode reversedTail = groupStart;
            prevGroupEnd.next = reversedHead;
            reversedTail.next = nextGroupStart;
            prevGroupEnd = reversedTail;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}