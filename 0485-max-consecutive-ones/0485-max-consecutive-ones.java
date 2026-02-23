class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int cnt=0;
        int max=0;
        for(int num:arr){
            if(num == 1){
                cnt++;
                max = Math.max(max, cnt);
            }
            else{cnt=0;}
        }
        return max;
    }
}