class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<n; i++){

            // 1. Remove elements outside the window
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

             // 2. Maintain decreasing order
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }

            // 3. Insert current index
            dq.offerLast(i);

            // 4. Window formed
            if(i >= k-1){
                result[i-k+1] = arr[dq.peekFirst()];
            }
        }
        return result;
    }
}