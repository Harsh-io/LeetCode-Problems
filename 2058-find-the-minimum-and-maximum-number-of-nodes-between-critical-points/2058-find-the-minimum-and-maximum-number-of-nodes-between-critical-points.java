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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
            
            ArrayList<Integer>arr = new ArrayList<>();

            if(head.next.next == null) return new int[]{-1, -1};

            ListNode temp = head.next;
            ListNode prev = head;
            ListNode next = temp.next;
            int i = 1; //temp position

            while(temp.next != null){

                if(prev.val < temp.val && temp.val > next.val){
                    arr.add(i);
                }
                else if(prev.val > temp.val && temp.val < next.val){
                    arr.add(i);
                }
                prev = temp;
                temp = temp.next;
                next = temp.next;
                i++;
            }

            if (arr.size() < 2) return new int[]{-1, -1};
            int minDist = Integer.MAX_VALUE;

            for(int j=1; j<arr.size(); j++){
                minDist = Math.min(minDist, arr.get(j) - arr.get(j - 1));
            }

            int maxDist = arr.get(arr.size() - 1) - arr.get(0);


            return new int[]{minDist, maxDist};
    }
}
//TC: O(N)
//SC: O(K) critical points