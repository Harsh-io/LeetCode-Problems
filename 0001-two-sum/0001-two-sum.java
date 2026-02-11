import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target){
        for(int i = 0 ; i<nums.length ; i++){
            for (int j = i+1 ; j<nums.length ; j++){
                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
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

















// MY CODE
    //     for(int num : nums){
    //         for(int n1 : nums)
    //         //traverse for all eelemts for this array 
    //         if(nums[num] + nums[num+1] == target){
    //             // add num to n[] array 

    //         }
    //     }
    // }












