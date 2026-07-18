class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;

        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];

            for(int j=i ;j<s.length(); j++){

                freq[s.charAt(j) - 'a']++;
                boolean valid = true;

                for(int f : freq) { 
                    if(f > 0 && f < k) { 
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}