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
    public ListNode middleNode(ListNode head) {
        
        int cnt = 0;
        ListNode temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        temp = head;
        int mid = cnt/2;
        cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == mid){
                head = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }
}