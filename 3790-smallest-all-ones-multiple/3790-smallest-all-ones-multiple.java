class Solution {
    public int minAllOneMultiple(int k) {

        int rem = 0;

        // If k has factors 2 or 5, repunit can never be divisible
        if(k % 2 == 0 || k % 5 == 0)  return -1;

        for(int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;

            if(rem == 0) return len;
        } 

        return -1;
    }
    
}