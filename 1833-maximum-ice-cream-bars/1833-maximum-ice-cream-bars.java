class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int cnt = 0;

        for(int cost : costs){
            if(coins >= cost){
                coins -= cost;
                cnt++;
            }else{break;}
        }
        return cnt;
    }
}