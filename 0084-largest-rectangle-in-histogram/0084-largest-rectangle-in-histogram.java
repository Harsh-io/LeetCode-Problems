class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int max = 0;
        int nse = n;
        int pse = -1;

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int ele = st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max, (arr[ele] * (nse-pse-1)));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nse = n;
            int i = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();

            max = Math.max(max, (arr[i] * (nse-pse-1)));
        }
        return max;
    }
}