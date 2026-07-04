class MyQueue {
    int start;
    int end;
    int currsize;
    int[] q;
    int size;

    public MyQueue() {
       start = -1;
       end = -1;
       currsize = 0;
       q = new int[10];
       size = q.length;
    }
    
    public void push(int x) {
        if(currsize == 0){
            start = 0;
        }
        if(currsize == size) return;
        else{
            end = (end+1)%size;
            q[end] = x;
            currsize++;
        }
    } 
    
    public int pop() {
        if(currsize == 0) return 1;
        int ele = q[start];
        if(currsize == 1){
            start = end = -1;
        }
        else{
            start = (start+1)%size;
        }
        currsize--;
        return ele;
    }
    
    public int peek() {
        if(currsize == -1) return 1;
        return q[start];
    }
    
    public boolean empty() {
        return currsize == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */