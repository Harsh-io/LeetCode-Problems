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