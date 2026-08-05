class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right, pile);
        }
        int ans = right;


        while(left < right){

            long hours = 0;
            int mid = left + (right - left)/2;

            for(int i=0; i<piles.length; i++){
                hours += Math.ceil((double)piles[i]/mid); 
            }

            if(hours <= h){
                right = mid; // try smaller speed
                ans = mid;
            }
            else left = mid + 1; // need faster speed 
        }
        return ans;
    }
}

        
        // int n = piles.length;

        // if(n <= h){
        //      Arrays.sort(piles);
        //     if(h-n < n-1) return piles[n-1-(h-n)];
        // }
