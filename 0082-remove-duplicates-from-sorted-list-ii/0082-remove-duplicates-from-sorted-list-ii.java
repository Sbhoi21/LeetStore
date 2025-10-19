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
        ListNode slow = new ListNode(0);
        ListNode temp = head;
        head = slow;

        while (temp != null) {
            if (temp.next !=null && temp.val == temp.next.val) {
                while (temp.next !=null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                temp = temp.next;
                continue;
            } 
                slow.next = temp;
                slow = slow.next;
                temp = temp.next;
            }
        slow.next = null;
        return head.next;
    }
    }