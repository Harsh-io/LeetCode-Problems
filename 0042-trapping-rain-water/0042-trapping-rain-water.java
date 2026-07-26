import java.util.*;
class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int totalWater = 0;
        int maxLeft = 0;
        int maxRight = 0;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }

        suffixMax[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        }

        for (int j = 0; j < n; j++) {
            maxLeft = prefixMax[j];
            maxRight = suffixMax[j];

            if(arr[j] < maxLeft && arr[j] < maxRight){
                totalWater += Math.min(maxLeft, maxRight) - arr[j];
            }
        } 
        return totalWater;
    }
}