class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seen0 = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                seen0 = true;
            }
            if(seen0 && s.charAt(i) == '1'){
                return false;
            }
        }

        return true;
    }
}