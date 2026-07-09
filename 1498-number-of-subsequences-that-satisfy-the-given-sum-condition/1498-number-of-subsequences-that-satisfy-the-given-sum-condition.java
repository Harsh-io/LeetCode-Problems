class Solution {
    public int numSubseq(int[] arr, int target) {

        Arrays.sort(arr);

        int n = arr.length;
        int mod = 1000000007;

        int[] pow = new int[n];
        pow[0] = 1;

        //store powers of two index wise
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }  

        int left = 0;
        int right = n-1;
        int ans = 0;

        while(left <= right){

            if(arr[left] + arr[right] <= target){
                ans = (ans + pow[right - left]) % mod;  //store all possible options : 2^n;
                left++;
            }else right--;
        }
        return ans;
    }
}

// class Solution {
//     int mod = 1000000007;

//     public int numSubseq(int[] arr, int target) {
//         return solve(0, arr, target, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
//     }

//     public int solve(int i, int[] arr, int target, int min, int max, boolean picked) {

//         if(i == arr.length){
//             if(picked && min+max <= target) return 1;
//             else return 0;
//         }

//         //pick arr[i]; 
//         int pick = solve(i+1, arr, target, Math.min(min, arr[i]), Math.max(max, arr[i]), true);

//         //not picked
//         int notPick = solve(i+1, arr, target, min, max, picked);

//         return (pick + notPick)%mod;
//     }
// }