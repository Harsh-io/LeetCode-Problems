class Solution {
    public int reverseBits(int n) {
        
        int ans = 0;

         for(int i = 0; i < 32; i++) {

            ans = ( ans<<1 ) | (n & 1);
            //int bit = n & 1;       // get last bit of n
            //ans = ans << 1;        // make space
            //ans = ans | bit;       // put bit into ans
            n = n >> 1;

        }
    return ans;
    }
}