//THINKING APPROACH 

//BRUTE FORCE
//Q is asking to do 2 things :
//1. Generate all sustring | 2. without repeating char and find max;



class Solution {
    public int lengthOfLongestSubstring(String s) {
        int  maxlen = 0;
        for(int i=0; i<s.length(); i++){

            Set<Integer> set = new HashSet<>();

            for(int j=i; j<s.length(); j++){
                if(set.contains(s.charAt(j) - 'a')) break;
                else set.add(s.charAt(j) -'a');

                int len = j-i+1;
                maxlen = Math.max(len, maxlen);
            }
        }
        return maxlen;
    }
}
//TC: O(N^2)
//SC: O(256)