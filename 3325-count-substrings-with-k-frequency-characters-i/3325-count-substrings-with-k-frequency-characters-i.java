class Solution {
    public int numberOfSubstrings(String s, int k) {
        int cnt  = 0 ;
        int[] freq = new int[26];
        int n = s.length();
        int left = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;

            //count possible substrings
            while(freq[ch-'a'] >= k){
                cnt += (n-i);
                char l = s.charAt(left);
                freq[l - 'a']--;
                left++;
            }
        }
        return cnt;
    }
}