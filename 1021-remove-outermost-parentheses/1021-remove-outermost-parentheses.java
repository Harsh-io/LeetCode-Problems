class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new  StringBuilder();
        int cnt = 0;

        for(char ch : s.toCharArray()){

            if(ch == '('){
                if(cnt > 0){
                    sb.append('(');
                }
                cnt++;
            }else if(ch == ')'){
                cnt--;
                if(cnt > 0) sb.append(')');
            }  
        }

        return sb.toString();
    }
}