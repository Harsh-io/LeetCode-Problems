class Solution {
    public int longestSubarray(int[] arr) {
        if(arr.length == 0 || arr.length == 2) return 0;
        if(arr.length == 3 && arr[2] != arr[1] + arr[0]) return 2;
        int max = 2;
        int cnt = 2;
        for(int i=2; i< arr.length; i++){
            if(arr[i] == arr[i-1]+arr[i-2]){
                cnt++;
                max = Math.max(max, cnt);
            }else{
                cnt = 2;
            }
        }
        
        return max;
    }
}