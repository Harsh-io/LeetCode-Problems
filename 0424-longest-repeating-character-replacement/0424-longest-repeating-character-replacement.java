class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0, right = 0;
        int maxCount = 0, maxlen =0;
        int[] freq = new int[26];

        while(right < s.length()){

            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount , freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }

        return maxlen;
    }
}