//Think of this as finding Longest subarray with Atmost   K    0’s

class Solution {
    public int longestOnes(int[] arr, int k) {
        int max = 0;
        int r = 0, l = 0;
        int zeros = 0;


        while(r < arr.length){

            if(arr[r] == 0) zeros++;

            if(zeros > k){

                if(arr[l] == 0) zeros--;
                l++;
            }
            if(zeros <= k){
                int len = r-l+1;
                max = Math.max(max, len);
            }
            r++;
        }
        return max;
    }
}

//TC : O(N)
//SC: O(1)