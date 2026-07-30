//
class LRUCache {
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int _key, int _val){
            key = _key;
            val = _val;
        }
    }

    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    void InsertAfter(Node node){
        Node currAfterhead = head.next;
        head.next = node;
        node.next = currAfterhead;
        node.prev = head;
        currAfterhead.prev = node;
    }

    void DeleteNode(Node node){
        Node back = node.prev;
        Node front = node.next;

        back.next = front;
        front.prev = back;
    }

    public int get(int key) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            DeleteNode(node);
            InsertAfter(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            DeleteNode(node);
            InsertAfter(node);
            return;
        }
        //else
        // filled the cache
         if(map.size() == cap){
            Node node = tail.prev;
            map.remove(node.key);
            DeleteNode(node);
         }

        //Add new Element
        Node node = new Node(key, value);
        map.put(key, node);
        InsertAfter(node);

    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
