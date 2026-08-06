class Solution {
    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            
            boolean dup = false;

            while(!st.isEmpty() && st.peek() == ch){
                dup = true;
                st.pop();
            }
            
            if(!dup) st.push(ch);
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}