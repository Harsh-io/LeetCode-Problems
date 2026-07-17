//Think of this as finding Longest subarray with Atmost   K    0’s

class Solution {
    public int longestOnes(int[] arr, int k) {
        int max = 0;
        int r = 0, l = 0;
        int zeros = 0;


        while(r < arr.length){
            if(arr[r] == 0) zeros++;
            while(zeros > k){
                if(arr[l] == 0) zeros--;
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}

//TC : O(N^2)
//SC: O(1)