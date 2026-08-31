/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode  next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = 0, count = 2, min = Integer.MAX_VALUE, lastPeak = 0;
        int prev = head.val;
        while (head.next != null) {
            if ((prev < head.val && head.val > head.next.val) ||
                    (prev > head.val && head.val < head.next.val)) {
                if (first > 0) {
                    min = Math.min(min, count - lastPeak);
                } else {
                    first = count;
                }
                lastPeak = count;
            }
            prev = head.val;
            head = head.next;
            count++;
        }

        int max = lastPeak == first ? -1 : lastPeak - first;
        min = lastPeak == first ? -1 : min;
        int[] p = { min, max };
        return p;
    }
}