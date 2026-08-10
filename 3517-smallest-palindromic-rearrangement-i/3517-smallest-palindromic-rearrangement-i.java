class Solution {
    public String smallestPalindrome(String s) {

        if(s.length() == 1) return s;

        int[] freq =  new int[26];
        StringBuilder sb = new StringBuilder();
        boolean mid = false;
        char m = '#';

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i=0; i<26; i++){
            
            if(freq[i] % 2 != 0){
                m = (char)('a' + i);
                mid = true;
            }

            for(int j = 0; j < freq[i] / 2; j++){
                sb.append((char)(i + 'a'));
            }
        }
        
        String str = sb.toString();
        String rev = sb.reverse().toString();
        
       

        return mid == true ?  str + Character.toString(m) + rev : str + rev;
    }
}