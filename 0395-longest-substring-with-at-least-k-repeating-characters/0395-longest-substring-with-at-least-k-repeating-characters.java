class Solution {
    public int longestSubstring(String s, int k) {

        int ans = 0;

        for(int targetUnique=1; targetUnique<=26; targetUnique++){

            int[] freq = new int[26];

            int left = 0;
            int right = 0;

            int unique = 0; //Number of distinct characters currently inside the window.
            int countatleastK = 0;  //Number of characters whose frequency is at least k

            while(right < s.length()){

                int idx = s.charAt(right) - 'a';

                if(freq[idx] == 0) unique++;

                freq[idx]++;

                if(freq[idx] == k) countatleastK++;

                right++;

                //trim from left 
                while(unique > targetUnique){

                    idx = s.charAt(left) - 'a';

                    if(freq[idx] == k) countatleastK--;

                    freq[idx]--;

                    if(freq[idx] == 0) unique--;

                    left++;
                    
                }
                if(unique == targetUnique && unique == countatleastK){
                    ans = Math.max(ans, right-left);
                }
            }
        }
        return ans;
    }
}