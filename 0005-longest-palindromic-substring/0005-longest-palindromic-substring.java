class Solution {
    public String expand(String s, int l, int r) {
        
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return s.substring(l+1, r);
    }

    public String longestPalindrome(String s) {
       
       int n = s.length();
       if(n == 1) return s;
       
       String ans = "";

       for(int i=0; i<n-1; i++){

            String odd = expand(s, i, i);
            
            if(odd.length() > ans.length()){
                ans = odd;
            }

            String even = expand(s, i, i+1);
            if(even.length() > ans.length()){
                ans = even;
            }
       }
       return ans;
    }
}