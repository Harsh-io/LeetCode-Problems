class Solution {
    public int getMinDistance(int[] arr, int target, int start) {
        int d = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                d = Math.min(d,Math.abs(i-start));
            }
        }
        return d;
    }
}