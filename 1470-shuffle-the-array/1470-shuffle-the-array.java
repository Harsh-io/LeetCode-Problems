class Solution {
    public int[] shuffle(int[] arr, int n) {
        int[] ans = new int[arr.length];
        int i = 0;
        int j = n;
        for(int k=0; k<arr.length; k++){
            if(k%2==0){
                ans[k] = arr[i];
                i++;
            }else{
                ans[k] = arr[j];
                j++;
            }
        }
        return ans;
    }
}

//TRY Doing this  using swapping
// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         for (int i = 0; i < n; i++) {
//             int j = n + i;   // position of y[i]

//             int temp = nums[j];

//             // shift elements right to make space
//             for (int k = j; k > 2 * i + 1; k--) {
//                 nums[k] = nums[k - 1];
//             }

//             nums[2 * i + 1] = temp;
//         }
//         return nums;
//     }
// }