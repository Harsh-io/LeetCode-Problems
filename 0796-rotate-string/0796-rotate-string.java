class Solution {
    public boolean rotateString(String s, String g) {
        if(s.length() != g.length()){return false;}

        for(int i=0; i<s.length(); i++){
            String r = s.substring(i,s.length()) + s.substring(0,i);
            if(r.equals(g)){return true;}
        }
        return false;
    }
}















//OPTIMAL
// String sb = s + s;
//return sb.contains(g);