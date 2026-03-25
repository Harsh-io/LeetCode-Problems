//Optimal - Prefix sum

//Brute Forcce
// class NumArray {
//     int[] arr; //first initialise -> class obj
//     public NumArray(int[] nums) { // constructor 
//         this.arr = nums; //Makes it accessible to all methods as "arr"
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;
//         while(left <= right){
//             sum = sum + arr[left];
//             left++;
//         }
//         return sum;
//     }
// }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

class NumArray {
    int[] prefix; 

    public NumArray(int[] nums){
        prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
       if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
}