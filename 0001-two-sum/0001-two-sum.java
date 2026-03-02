import java.util.*;

class Solution {
    public int[] twoSum(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int b = target - arr[i];
            if(map.containsKey(b))
                return new int[]{map.get(b),i};
            map.put(arr[i],i);
        }
        return new int[0];
    }
}
//BRUTE FORCE
        // for(int i=0; i<arr.length-1; i++){
        //     for(int j=i+1; j<arr.length; j++){
        //         if(arr[i] + arr[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[0];
        // }
















