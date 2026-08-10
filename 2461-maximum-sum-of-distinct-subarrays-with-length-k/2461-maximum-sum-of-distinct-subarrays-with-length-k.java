class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        
        int i=0;
        int j=0;

        long sum = 0;
        long max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < arr.length){

            sum += arr[j];
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);

            if(j-i+1 > k){

                sum -= arr[i];

                map.put(arr[i], map.getOrDefault(arr[i], 0)-1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);

                i++;
            }

            if(j-i+1 == k){
                if(map.size() == k) max = Math.max(max, sum);
            }
            j++;
        }

        return max;
    }
}