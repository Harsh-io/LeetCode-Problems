class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr2){

            while(!st.isEmpty() && st.peek() < num){
                map.put(st.pop(), num);
            }

            st.push(num);
        }

        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = map.get(arr1[i]);
        }

        return result;
    }
}