class Solution {
    public int[] singleNumber(int[] arr) {

        int xor = 0;

        // XOR all numbers
        for(int num : arr){
            xor ^= num;
        }

         // Rightmost set bit
        int diff = xor & -xor;

        int a = 0;
        int b = 0;

        // Divide into two groups
        for(int num : arr) {

            if((num & diff) == 0) a = a ^ num;
            else b = b ^ num;
        }

        return new int[]{a, b};
    }
}