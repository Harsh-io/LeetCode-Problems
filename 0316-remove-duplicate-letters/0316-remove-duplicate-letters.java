class Solution {
    public String removeDuplicateLetters(String s) {

        boolean[] taken = new boolean[26];
        int[] last = new int[26];

        //store the last occurence of each character
        for(int i=0; i<s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(taken[ch - 'a']) continue;

            while(sb.length() > 0 && sb.charAt(sb.length()-1) > ch && last[sb.charAt(sb.length()-1) - 'a']> i){

                taken[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }

            sb.append(ch);
            taken[ch - 'a'] = true;
        }
        return sb.toString();
    }
}