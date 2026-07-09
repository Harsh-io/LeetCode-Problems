class Solution {

    boolean solve(String s, int i, int j){
        if(i >= j) return true;

        if(s.charAt(i) == s.charAt(j)){
            return solve(s, i+1, j-1);
        }
        return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int sp = 0;

        for(int i=0; i<n; i++){
            for(int j =i; j<n; j++){

                if(solve(s, i, j) == true){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxLen);
    }
}

// int n = s.length();
    //     String ans = "";

    //     for(int i=0; i<n; i++){

    //         String odd = expand(s, i, i);
    //         if(odd.length() > ans.length()){
    //         ans = odd;
    //         }

    //         String even = expand(s, i, i+1);
    //         if(even.length() > ans.length()){
    //             ans = even;
    //         }
    //     }
    //      return ans;
    // }

    // public String expand(String s, int l, int r){
        
    //     while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
    //         l--;
    //         r++;
    //     }
        
    //     return s.substring(l+1,r);