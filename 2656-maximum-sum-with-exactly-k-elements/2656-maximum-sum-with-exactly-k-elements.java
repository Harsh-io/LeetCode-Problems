//BRUTE FORCE
// class Solution {
//     public int maximizeSum(int[] arr, int k) {
//         Arrays.sort(arr);

//         int n = arr.length;
//         int ans = 0;

//         for(int i=0; i<k; i++){
//             ans += arr[n-1];
//             arr[n-1] = arr[n-1] + 1;
//         }
//         return ans;
//     }
// }

class Solution {
    public int maximizeSum(int[] arr, int k) {
        
        int max = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            max = Math.max(arr[i], max);
        }

        int ans = 0;
        for(int j=0; j<k; j++){
            ans += max;
            max++;
        }
        return ans;
    }
}