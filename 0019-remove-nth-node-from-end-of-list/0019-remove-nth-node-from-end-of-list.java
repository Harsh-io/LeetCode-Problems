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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        int cnt = 0;
        ListNode temp = head;
        
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        if(cnt == n) return head.next;

        int steps = cnt - n - 1;
        temp = head;
        while(steps > 0){
            temp = temp.next;
            steps--;
        }
        temp.next = temp.next.next;

        return head;
    }
}
//TC: O(len) + O(len-n);
//SC; O(1)
//Worst case TC: if n=1 } 2 x O(len)


// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;

//         ListNode fast = dummy;
//         ListNode slow = dummy;

//         for(int i = 0; i < n; i++) {
//             fast = fast.next;
//         }

//         while(fast.next != null) {
//             fast = fast.next;
//             slow = slow.next;
//         }

//         slow.next = slow.next.next;

//         return dummy.next;
//     }
// }