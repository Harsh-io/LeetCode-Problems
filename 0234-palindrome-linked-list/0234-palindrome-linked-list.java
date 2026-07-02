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
// class Solution {
//     public boolean isPalindrome(ListNode head) {

//         Stack<Integer> st = new Stack<>();
//         ListNode temp = head;

//         while(temp != null){
//             st.push(temp.val);
//             temp = temp.next;
//         }

//         temp = head;
//         while(temp != null){
//             if(temp.val != st.peek()) return false; //st.pop() gives EXMPTY STACK EXCEPTION
//             temp = temp.next;
//             st.pop();
//         }
//         return true;
//     }
// }
//TC: O(2N)
//SC: O(N); 


//LL1 -> stack -> LL2 | compare L1 and L2
//LL -> stack | compare stack and LL

class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;   //TC: O(N/2)
        } 
        ListNode newHead = reverse(slow.next);   //TC: O(N/2)
         
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val) {
                reverse(newHead);    //TC: O(N/2)
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
//TC: O(N)
//SC: O(1)