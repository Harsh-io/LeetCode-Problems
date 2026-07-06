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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;

        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        k = k % len;
        if(k == 0) return head;
        int cnt = 0;

        ListNode newHead = head;
        ListNode tail = head;
        while(tail.next != null){
            cnt++;
            tail = tail.next;
            if(cnt < len-k)newHead = newHead.next;
        }
        tail.next = head;
        head = newHead.next;
        newHead.next = null;

        return head;
    }
}