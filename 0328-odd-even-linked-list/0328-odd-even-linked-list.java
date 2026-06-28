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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        if(temp == null || temp.next == null){
            return temp;
        }
        ArrayList<Integer> arr = new ArrayList<>();

        //TC : O(N/2) | ODD
        while(temp != null && temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) arr.add(temp.val);

        //TC : O(N/2) | EVEN
        temp = head.next;
        while(temp != null && temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null) arr.add(temp.val);

        temp = head;
        for (int i=0; i<arr.size(); i++){
            temp.val = arr.get(i);
            temp = temp.next;
        }

        return head;
    }
}