class Solution {
    public String breakPalindrome(String s) {

        if(s.length() == 1) return "";

        boolean found = false;
        StringBuilder str = new StringBuilder(s);

        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) -'a' != 0){
                str.setCharAt(i,'a');
                found = true;
                break;
            }
        }

        if(found) return str.toString();

        str.setCharAt(str.length()-1,'b');
        return str.toString();

    }
}