//THINKING APPROACH 

//BRUTE FORCE
//Q is asking to do 2 things :
//1. Generate all sustring | 2. without repeating char and find max;



class Solution {
    public int lengthOfLongestSubstring(String s) {
        int  maxlen = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()){

            char ch = s.charAt(r);
            // map.get(ch) >= l check whether the previous occurrence of ch is inside the current sliding window.
            if(map.containsKey(ch) && map.get(ch) >= l){   
                l = map.get(ch) + 1;
            }
            
            map.put(ch, r);

            int len = r-l+1;
            r++;
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
}
//TC: O(N^2)
//SC: O(256)