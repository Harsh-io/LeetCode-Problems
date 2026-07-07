/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
    //     if(head == null || head.next == null) return head;

        Node temp = head;
        HashMap<Node, Node>map = new HashMap<>();

        while(temp != null){
            Node newnode = new Node(temp.val);
            map.put(temp,newnode);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node CopyNode = map.get(temp);
            CopyNode.next = map.get(temp.next);
            CopyNode.random = map.get(temp.random);

            temp = temp.next;
        }
        return map.get(head);
    }


        // for (Map.Entry<Node, Node> e : map.entrySet()) {
        //             Node original = e.getKey();
        //             Node copy = e.getValue();

        //             copy.next = map.get(original.next);
        //             copy.random = map.get(original.random);
        //         }

        //         return map.get(head);
        //     }
}

//TC: O(2N) -> while loop twice
//SC: O(N) + O(N) -> hashmap and copy node