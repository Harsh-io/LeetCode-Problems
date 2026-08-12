class Solution {
    public int maxSubarrayLength(int[] arr, int k) {

        int l = 0, r = 0;
        int maxl = 0;
        int maxfreq = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); 

        while(r < arr.length){

            map.put(arr[r], map.getOrDefault(arr[r] ,0)+1);
            maxfreq = Math.max(maxfreq, map.get(arr[r]));

            while(maxfreq > k){

                if(map.get(arr[l]) ==  maxfreq) maxfreq--;
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if(map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;

            }

            if(maxfreq <= k){
                maxl = Math.max(maxl, r-l+1);
            }

            r++;
        }

        return maxl;
    }
}