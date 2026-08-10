class Solution {

    public boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public int countSubstrings(String s) {
        
        int cnt = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){

                if(isPalindrome(s.substring(i, j+1))) cnt++;

            }
        }
        return cnt;
    }
}