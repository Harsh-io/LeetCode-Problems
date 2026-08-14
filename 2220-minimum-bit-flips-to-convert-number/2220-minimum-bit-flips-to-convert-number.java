class Solution {
    public int minBitFlips(int start, int goal) {
        
        goal = start ^ goal;
        int cnt = 0;

        while(goal > 0){

            goal = goal & (goal-1);
            cnt++;
        }

        return cnt;
    }
}