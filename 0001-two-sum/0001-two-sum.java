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
//TC: O(NLOGN)
//SC: O(N)

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
        //TC: O(N2); SC: 0(1)

//Greedy Approach + 2  Pointer 
// int n = arr.length;
// int[][] Original = new int[n][2];

// for(int i=0; i<arr.length; i++){
//     Original[i][0] = arr[i];
//     Original[i][1] = i;
// }
// Arrays.sort(Original, (a,b) -> Integer.compare(a[0], b[0]));
// int i=0, j = n-1;
// while (i < j) {
//             int sum = Original[i][0] + Original[j][0];
//             if (sum == target) {
//                 return new int[] {Original[i][1], Original[j][1]};
//             } else if (sum < target) {
//                 i++;
//             } else {
//                 j--;
//             }
//         }
//         return new int[] {-1, -1};
//     }
// }
//TC:O(N) | SC: O(n) 
















