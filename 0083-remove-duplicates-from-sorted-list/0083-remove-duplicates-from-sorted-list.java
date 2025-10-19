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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val != slow.val) {
                slow.next = temp;
                slow = slow.next;
            }
            temp = temp.next;
        }
        slow.next = null;
        return head;
    }
}