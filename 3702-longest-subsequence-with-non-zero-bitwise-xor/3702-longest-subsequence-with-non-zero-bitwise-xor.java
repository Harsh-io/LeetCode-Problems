class Solution {
    public int longestSubsequence(int[] arr) {

        int xor = 0;
        boolean hasNonZero = false;

        for (int num : arr) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (xor != 0) return arr.length;
        if (hasNonZero == true) {
            return arr.length - 1;
        }

        return 0;
    }
}