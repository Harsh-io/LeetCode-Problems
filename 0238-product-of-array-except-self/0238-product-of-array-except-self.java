// class Solution {
//     public int[] productExceptSelf(int[] arr) {
//         int[] ans = new int[arr.length];
//         for(int i=0; i<arr.length; i++){
//             int mul = 1;
//             for(int j=0; j<arr.length; j++){
//                 if(arr[j] == 0 && i != j ){mul = 0;}
//                 else if(i != j){ mul = mul * arr[j];}
//             }
//             ans[i] = mul;
//         }
//         return ans;
//     }
// }


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        //store left products
        ans[0] = 1;
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        //multiply right products
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }
        return ans;
    }
}