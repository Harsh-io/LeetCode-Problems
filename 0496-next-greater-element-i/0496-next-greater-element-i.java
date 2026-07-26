class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        int n = arr2.length;
        int[] ans = new int[n];
        int[] res = new int[arr1.length];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && st.peek() < arr2[i]){
                st.pop();
            }

            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(arr2[i]);
        }

        for(int i=0; i<arr1.length; i++){
            int ele = arr1[i];
            for(int j=0; j<n; j++){
                if(ele == arr2[j]){
                    res[i] = ans[j];
                }
            }
        }
        return res;
    }
}