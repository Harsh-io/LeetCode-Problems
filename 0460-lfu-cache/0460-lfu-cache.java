class LFUCache {

    class Node{
        int key, val, freq;
        Node next;
        Node prev;

        Node(int key_, int val_){
            key = key_;
            val = val_;
            freq = 1;
        }
    }
    
    class List{
        int size;
        Node head;
        Node tail;

        List(){
            tail  = new Node(0, 0);
            head = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFront(Node node){
            Node temp = head.next;
            head.next = node;
            node.next = temp;
            temp.prev = node;
            node.prev = head;
            size++;
        }

        void removeNode(Node node){
            Node back = node.prev;
            Node front = node.next;

            back.next = front;
            front.prev = back;
            size--;
        }
    }

    
    HashMap<Integer, Node> keyNode;
    HashMap<Integer, List> freqListMap;
    int maxsize;
    int currsize;
    int leastfreq;

    public LFUCache(int capacity) {
        maxsize = capacity;
        leastfreq = 0;
        currsize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }
    
    public int get(int key) {
        
        if(keyNode.containsKey(key)){

            Node node = keyNode.get(key);
            int val = node.val;
            updateFreqList(node);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if (maxsize == 0) {
            return;
        }

        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.val = value;
            updateFreqList(node);
        }else{

            //When the cache is full: 
            //Find the list having the minimum frequency (minFreq).
            //Find the least recently used node inside that list.
            //Remove that node from the HashMap.
            //Remove that node from the doubly linked list.
            //Decrease the cache size.

            if(currsize == maxsize){
                List list = freqListMap.get(leastfreq);
                keyNode.remove(list.tail.prev.key);

                freqListMap.get(leastfreq).removeNode(list.tail.prev);
                currsize--;
            }

            currsize++;
            leastfreq = 1;

            //Create a new node.
            //Put it into the linked list of frequency 1.
            //Store the key → node mapping.
            //Store the frequency → list mapping.

            List listFreq;

            if(freqListMap.containsKey(leastfreq)){
                listFreq = freqListMap.get(leastfreq);
            }else{
                listFreq = new List();
            }
            Node node = new Node(key, value);

            listFreq.addFront(node);

            keyNode.put(key, node);

            freqListMap.put(leastfreq, listFreq);
        }
    }


    public void updateFreqList(Node node) {
        //Remove the node from its current frequency list.
        //Increase its frequency by 1.
        //Move it to the next higher frequency list.
        //Update the HashMaps.

        keyNode.remove(node.key);

        freqListMap.get(node.freq).removeNode(node);

        if(node.freq == leastfreq  && freqListMap.get(node.freq).size == 0){
            leastfreq++;
        } 

        List nexthighfreqlist = new List();

        if(freqListMap.containsKey(node.freq+1)){
            nexthighfreqlist = freqListMap.get(node.freq + 1);
         }

         node.freq += 1;

         nexthighfreqlist.addFront(node);

         freqListMap.put(node.freq, nexthighfreqlist);
         keyNode.put(node.key, node);
         
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */