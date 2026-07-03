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
        
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode nextNode = temp.next;
            boolean duplicate = false;

            while(nextNode != null && nextNode.val == temp.val){
                duplicate = true;
                nextNode = nextNode.next;
            }

            if(duplicate){
                if(prev == null) head = nextNode;
                else prev.next = nextNode;

                temp = nextNode;
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}

//3 nodes -> 
// temp and temp.next;

// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if(head == null || head.next == null) return null;

//         ListNode temp = head;
//         ListNode prev = head;
//         ListNode front = temp.next;

//         while(temp != null && temp.next != null){
            
//             while(temp.val == temp.next.val){
//                 prev = temp;
//                 temp = temp.next;
//             }

//             prev.next = temp;
//             temp = temp.next;   
//         }
//         return head;
//     }
// }
