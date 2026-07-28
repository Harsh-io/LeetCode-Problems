class Solution {
    public String smallestPalindrome(String s) {
        int[] a = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            a[ch - 'a']++;
        }

        char mid = '\0';
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a.length; i++){

            char ch = (char)(i + 'a');

            for (int j = 0; j < a[i] / 2; j++) {
                sb.append(ch);
            }

            if (a[i] % 2 == 1) mid = ch;
        }
        
        String left = sb.toString();
        String right = sb.reverse().toString();

        if(mid == '\0'){
            return left + right;
        }     
        else{
            return left + mid + right;
        }     
    }
}