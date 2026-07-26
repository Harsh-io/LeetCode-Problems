class Solution {
    public int trap(int[] arr) {
        
        int leftMax = 0, rightMax = 0;
        int total = 0;
        int l = 0, r = arr.length-1;

        while(l < r){

            if(arr[l] <= arr[r]){

                if(leftMax > arr[l]){
                    total += leftMax  - arr[l];
                }else{
                    leftMax = arr[l];
                }
                l++;
            }else{
                if(rightMax > arr[r]){
                    total += rightMax - arr[r];
                }else{
                    rightMax = arr[r];
                }
                r--;
            }
        }
        return total;
    }
}
//TC: O(N)
//SC: O(1)