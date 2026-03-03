import java.util.*;
class Solution {
    public int majorityElement(int[] arr) {
        int cnt = 0;
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                max = arr[i];
            } else if (max == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                cnt1++;
            }
        }
        if (cnt1 > (arr.length / 2)) {
            return max;
        }
        return -1;
    }
}

//BRUTE FORCE 
// 2 for loop count occurence and print for (> n/2)

//HashMap
// HashMap<Integer, Integer> map = new HashMap<>();
// for(int num: arr){
//     map.put(num, map.getOrDefault(num,0)+1);
// }


//Default syntax: for(Map.Entry<KeyType, ValueType> variable : map.entrySet())- entryset gives key value pair 
// for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//     if (entry.getValue() > n / 2) {
//         return entry.getKey();
//     }
// }