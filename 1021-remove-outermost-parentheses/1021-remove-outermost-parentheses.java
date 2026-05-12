class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int lvl = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                if(lvl > 0){sb.append('(');}
                lvl++;
            }else if(ch == ')'){
                lvl--;
                if(lvl > 0){sb.append(')');}
            }
        }
        return sb.toString();
    }
}