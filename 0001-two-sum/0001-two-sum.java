import java.util.*;

class Solution {
    public int[] twoSum(int[] arr, int target){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
        }
}

// OPTIMAL ONE
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             int diff = target - nums[i];
//             if (map.containsKey(diff))
//                 return new int[] { map.get(diff), i };
//             map.put(nums[i], i);
//         }
//         return new int[0];
















