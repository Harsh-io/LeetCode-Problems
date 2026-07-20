// Exactly K distinct subarrays = At most K distinct subarrays - At most (K-1) distinct subarrays
class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        
        return solve(arr, k) - solve(arr, k-1);
    }

    public int solve(int[] arr, int k){

        if(k == 0) return 0;

        int ans = 0;
        int r = 0;
        int l = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(r < arr.length){

            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            while(map.size() > k){
                
                map.put(arr[l], map.get(arr[l]) - 1);

                if(map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }

            if(map.size() <= k){
                ans += r-l+1;
            }
            r++;
        }
        return ans;
    }
}