class Solution {
    public int findMaxLength(int[] arr) {

        int n = arr.length;
        int maxl = 0;
        int sum = 0; 

        HashMap<Integer, Integer> map = new HashMap<>();
        // prefix sum 0 exists before starting
        map.put(0, -1);

        
        for(int i=0; i<n; i++){
            
            // convert 0 to -1 and 1 to +1
            if(arr[i] == 1)sum++;
            else sum--;

            // if this sum was seen before
            if(map.containsKey(sum)){

                int len = i - map.get(sum);
                maxl = Math.max(maxl, len);
            }
            else{
            // store first occurrence only
            map.put(sum, i);
            }
        }
    return maxl;
    }
}