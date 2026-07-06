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

        if(head == null || head.next == null)return head;

        ListNode temp = head;
        ListNode nextGroup = null; 
        ListNode prevGroup = null;

        while(temp != null){
            ListNode KthNode = findKthNode(temp, k);

            if(KthNode == null){
                if(prevGroup != null) prevGroup.next = temp;
                break;
            }

            nextGroup = KthNode.next;
            KthNode.next = null;
            
            reverse(temp);

            if(temp == head) head = KthNode;
            else prevGroup.next = KthNode;

            prevGroup = temp;

            temp.next = nextGroup;

            temp = nextGroup;
        }
        return head;
    }

    public ListNode findKthNode(ListNode node, int k){
        while(node != null && k > 1){
            node = node.next;
            k--;
        }
        return node;

    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}