class Solution {
    public int countKDifference(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count =0;

        for(int i=0; i<arr.length; i++){
            
            count += map.getOrDefault(arr[i] + k, 0);
            count += map.getOrDefault(arr[i] - k, 0);

            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
    return count;
    }
}



//for loop 
//hash map