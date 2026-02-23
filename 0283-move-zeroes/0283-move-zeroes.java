// class Solution {
//     public void moveZeroes(int[] nums) {
//         int insertPos = 0; // Where the next non-zero should be placed

//         // First pass: move all non-zero numbers to the front
//         for (int num : nums) {
//             if (num != 0) {
//                 nums[insertPos++] = num;
//             }
//         }

//         // Second pass: fill the rest of the array with zeroes
//         while (insertPos < nums.length) {
//             nums[insertPos++] = 0;
//         }
//     }
// }


class Solution {
    public void moveZeroes(int[] arr){
        int cnt=0;
        for(int j=0; j<arr.length; j++){
            if(arr[j] != 0){                
                //swap
                int temp = arr[cnt];
                arr[cnt]=arr[j];
                arr[j]=temp;
                cnt++;
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ' ' );
        }
    }
}